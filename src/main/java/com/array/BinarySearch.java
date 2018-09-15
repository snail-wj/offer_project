package com.array;

/**
 * @author WJ
 * @date 2018/09/13
 * 二分查找:适用范围，对于一个数组已经排好了序
 */
public class BinarySearch {

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
