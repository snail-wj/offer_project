package com.coding_interiews.demo40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author WJ
 * @date 2018/07/28
 *
 * 面试题40:最小的k个数
 *
 * 题目:
 *  输入 n 个整数，找出其中最小的 k 个数。
 *  输入 n 个整数，找出其中最小的 k 个数。
 *
 *  问题:
 *   最大堆
 *
 *  思路:
 *  1. 使用最大堆，优先队列 PriorityQueue 和比较器 Comparator
 *  2. 将数组的中前 k 个数字存储到 最大堆中
 *  3. 遍历在数组区间[k,n)的元素，
 *        如果该元素小于最大堆中的第一个元素，则最大堆中的第一个元素出队，将该元素加入最大堆中
 *
 *  参考url：
 *  https://blog.csdn.net/liyazhou0215/article/details/72803003
 */
public class demo40 {

    public static Queue<Integer> getMaxHeap(int k){
        Comparator<Integer> revCmp = new Comparator<Integer>(){

            @Override
            public int compare(Integer first, Integer second) {
                return second - first;
            }
        };
        return new PriorityQueue<>(k, revCmp);
    }

    public static Integer[] minNums( int[] array, int k){

        Queue<Integer> maxHeap = getMaxHeap(k);
        for(int i = 0; i < k; i++){
            maxHeap.offer(array[i]);
        }

        for(int i = k ; i < array.length ; i ++){
            if(array[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }

        return maxHeap.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int [][] arrays = {{4,5,1,6,2,7,2,8},{4,5,1,6,2,7,3,8,-1,10,-2}};
        for(int i = 0; i < arrays.length; i ++){
            Integer[] minNums = minNums(arrays[i], 5);
            System.out.println(Arrays.toString(minNums));
        }
    }
}
