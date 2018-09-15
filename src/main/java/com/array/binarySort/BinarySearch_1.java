package com.array.binarySort;

/**
 * @author WJ
 * @date 2018/09/13
 * 二分查找:适用范围，对于一个数组已经排好了序
 * 给定一个有序的数组，查找value是否在数组中，不存在返回-1。
 */
public class BinarySearch_1 {

    private static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length - 1;

        //这里必须是<=
        while (left <= right){
            int mid = (left + right) / 2;
            if(array[mid] == key){
                return mid;
            }
            else if(array[mid] < key){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,3,4,6,7,9,5};
        System.out.println(binarySearch(array, 7));
    }
}
