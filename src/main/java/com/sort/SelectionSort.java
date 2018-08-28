package com.sort;

import java.util.Arrays;

/**
 * @author WJ
 * @date 2018/08/29
 * 选择排序
 * 动画参考url:https://www.cnblogs.com/onepixel/articles/7674659.html
 */
public class SelectionSort {

    private static void sort(int[] array) {
        int length = array.length;
        int minIndex, temp;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};
        sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i + "\t"));
    }
}
