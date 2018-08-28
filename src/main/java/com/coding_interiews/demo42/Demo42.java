package com.coding_interiews.demo42;

import java.util.Arrays;

/**
 * @author WJ
 * @date 2018/07/29
 * 面试题42:连续子数组中的最大和
 *
 * 题目:
 *  输入一个整型数组，数组里有正数也有负数。数组中一个或者连续的多个整数组成一个子数组。
 *  求所有子数组的和的最大值。要求时间复杂度是 O(n)。
 *
 * 考察点:
 *  1.动态规划
 *    函数 f(i) 表示以第 i 个数字结尾的子数组的最大和
 */
public class Demo42 {

    public static int findMaxSumOfSubArray(int[] array) {
        if (array == null) {
            throw new RuntimeException("invalid input. Array is null");
        }

        int maxSum = array[0];
        int currSum = array[0];

        for (int i = 1; i < array.length; i++) {
            //当前元素之前的若干元素的和currSum,if currSum < 0,表示实负资产，不参与下一轮的计算
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += array[i];
            maxSum = maxSum > currSum ? maxSum : currSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, -2, 3, 10, -4, 7, 2, -15},
                {5, -1, -3, -4, -7, -2, -15},
                {-5, 1, -3, -4, -7, -2, -15}
        };

        for(int i = 0; i < arrays.length; i++){
            System.out.print(Arrays.toString(arrays[i]) + "\t");
            System.out.println(findMaxSumOfSubArray(arrays[i]));
        }
    }
}
