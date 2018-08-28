package com.coding_interiews.demo41;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @author WJ
 * @date 2018/07/29
 * 面试题41:数据流中的中位数
 *
 * 题目:
 *  如何得到一个数据流中的中位数？
 *  如果从数据流中读出期数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *  如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 考察点:
 *  1.查找
 *  2.最大堆和最小堆
 *
 * 参考url:
 *  https://blog.csdn.net/liyazhou0215/article/details/73477009
 */
public class Demo41 {

    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    /**
     * 插入数据
     * @param num
     *
     * 当前数字为偶数的时候 -> minHeap
     * 当前数字为奇数的时候 -> maxHeap
     */
    public void insert(int num) {

        //数字的总数为偶数的时候，将新的数据插入到最小堆里面(最小堆里面保存的都是较大的数字)
        //若当前的值比最大堆的最大值小，则将当前数字和最大堆的最大数字进行交换(为了保证最大堆的值始终不大于最小堆的最小值)
        //即，当前的数字保存在最大堆中，将最大堆中的最大数字要弹出保存在最小堆中
        if (((minHeap.size() + maxHeap.size()) & 1) == 0) {
            if (maxHeap.size() > 0 && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            //数字的总数为奇数，将新的数据要插入到最大堆中(最大堆中保存的都是较小的数字)
            //若当前的值比最小堆中的最小值大，则将当前数字和最小堆中的最小值交换(为了保证最大堆的值始终不大于最小堆的最小值)
            //即，将当前数字存放到最小堆中，将最小堆中的最小数字弹出并保存到最大堆中
            if (minHeap.size() > 0 && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public double getMedia() {
        int size = minHeap.size() + maxHeap.size();
        if (size == 0) {
            throw new IllegalArgumentException("Argument is illegal.");
        }
        double medain = 1;
        if ((size & 1) == 1) {
            medain = minHeap.peek();
        }else {
            medain = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return medain;
    }

    public static void main(String[] args) {
        Demo41 demo41 = new Demo41();
        Random random = new Random();
        int N = 10;
        for(int i = 0; i < N ; i++){
            demo41.insert(random.nextInt(100));
        }
        for (int i = 0 ; i < 5 ; i++){
            demo41.insert(random.nextInt(100));
            System.out.println("maxHeap:" + demo41.maxHeap);
            System.out.println("minHeap:" + demo41.minHeap);
            System.out.println(demo41.getMedia());
            System.out.println();
        }
    }

}
