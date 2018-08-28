package com.sort;

import java.util.Arrays;

/**
 * @author WJ
 * @date 2018/08/29
 * 3.插入排序
 * 动画参考url:https://www.cnblogs.com/onepixel/articles/7674659.html
 */
public class InsertionSort {
    private static void sort(int[] array) {
        int len = array.length;
        int preIndex, current;
        for(int i = 1; i < len ; i++){
            preIndex = i - 1;
            current = array[i];
            while (preIndex >= 0 && array[preIndex] > current){
                array[preIndex + 1] = array[preIndex];
                preIndex --;
            }
            array[preIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1,2};
        sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i + "\t"));
    }
}
