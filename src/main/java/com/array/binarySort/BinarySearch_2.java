package com.array.binarySort;

/**
 * @author WJ
 * @date 2018/9/15
 *
 */
public class BinarySearch_2 {

    /**
     * 给定一个有序的数组，查找value第一次出现的下标，不存在返回-1。
     * @param array
     * @param target
     * @return
     */
    public static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (array[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return array[right + 1] == target ? right + 1 : -1;
    }

    /**
     * 给定一个有序的数组，查找value最后一次出现的下标，不存在返回-1。
     * @param array
     * @param target
     * @return
     */
    public static int binarySearch_1(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (array[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return array[left - 1] == target ? left - 1 : -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 6, 7, 9, 9};
        System.out.println(binarySearch(array, 7));


        int[] array1 = {1, 3, 4, 6, 7, 9, 9, 10, 10, 10, 11};
        System.out.println(binarySearch_1(array1, 4));

    }



}
