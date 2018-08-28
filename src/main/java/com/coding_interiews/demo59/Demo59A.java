package com.coding_interiews.demo59;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WJ
 * @date 2018/08/08
 * 面试题59(第一题):滑动窗口的最大值
 *
 * 题目:
 *  给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 *  例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小 3，
 *  那么移动存在 6 个滑动窗口，它们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 *
 * 考察点:
 *  双端队列的应用
 *
 * 参考url:
 *  https://blog.csdn.net/liyazhou0215/article/details/77446934
 */
public class Demo59A {

    private static List<Integer> maxInWindows(int[] num, int size) {
        List<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size < 1) {
            return result;
        }
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            //保证添加新的元素之前，窗口中首尾元素下标之差最大是size
            if(i > 0 && !deque.isEmpty()){
                int firstIdx = deque.peekFirst();
                int diff = i - firstIdx;
                if(diff == size){
                    deque.pollFirst();
                }
            }

            //同一个窗口中的元素如果小于新的元素，则被删除
            //由于前面的元素总是大于后面的元素，所以从后面删除
            while (!deque.isEmpty() &&num[i]>= num[deque.peekLast()]){
                deque.pollLast();
            }

            //新元素总是会被添加双端队列的末尾
            deque.offerLast(i);

            //双端队列的队头存放的是一个窗口的最大值
            if(i >= size - 1){
                result.add(num[deque.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(array, 3));
    }
}
