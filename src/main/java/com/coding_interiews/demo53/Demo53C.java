package com.coding_interiews.demo53;

/**
 * @author WJ
 * @date 2018/08/04
 * 面试题53(习题3)：数组中数值和下标相等的元素
 *
 * 题目:
 *假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 * 例如，在数组{-3, -1, 1, 3, 5}中，数字3和它的下标相等
 */
public class Demo53C {

    private static int getNumberSameAsIndex(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int middle = (left + right) >> 1;
            if (numbers[middle] == middle) {
                return middle;
            }
            if (numbers[middle] > middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array1 = {-3,-1,1,3,5};
        int[] array2 = {2,3,4,5,6,7};
        System.out.println(getNumberSameAsIndex(array1));
        System.out.println(getNumberSameAsIndex(array2));
    }
}
