package com.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author WJ
 * @date 2018/08/28
 * 冒泡排序:相邻的两个元素，两两进行比较
 * 动画参考url:https://www.cnblogs.com/onepixel/articles/7674659.html
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};
        System.out.println("排序前数组为:");
        Arrays.stream(arr).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        //外层循环控制排序趟数
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环控制每一趟排序多少次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后数组为:");
        Arrays.stream(arr).forEach(i -> System.out.print(i + "\t"));
    }
}
