package com.coding_interiews.demo39;

/**
 * @author WJ
 * @date 2018/07/28
 * 面试题39：数组中出现次数超过一半的数字
 *
 * 题目:
 *  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *  由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *
 *
 */
public class Demo39 {

    /**
     * 检查数组是否合法
     * @param numbers
     * @param length
     * @return
     */
    public static boolean checkInvalidArray(int[] numbers, int length) {
        boolean isInvalidArray = false;
        if (numbers == null || length <= 0) {
            isInvalidArray = true;
        }
        return isInvalidArray;
    }

    /**
     * 检查是否数组中真的存在有超过一半的数字
     * @param numbers
     * @param length
     * @param number
     * @return
     */
    public static boolean checkMoreThanHalf(int[] numbers, int length, int number) {
        int times = 0;
        for (int i = 0; i < length; i++) {
            if (number == numbers[i]) {
                times++;
            }
        }
        boolean isMorenHanHalf = true;
        if (times * 2 <= length) {
            isMorenHanHalf = false;
        }
        return  isMorenHanHalf;
    }

    public static int moreThanHalfNum(int[] numbers, int length) {
        if (checkInvalidArray(numbers, length)) {
            return 0;
        }
        int result = numbers[0];
        int times = 1;
        for (int i = 1; i < length; i++) {
            if (times == 0) {
                result = numbers[i];
                times++;
            } else if (result == numbers[i]) {
                times++;
            } else {
                times--;
            }
        }
        if(!checkMoreThanHalf(numbers, length, result)){
            result = 0;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,3,4,5,2,2,2};
        int[] nums2 = {1,2,2,3,4,5,2,2,2,3};
        int[] nums3 = {1,2,2,3,4,5,2,2,2,3};
        System.out.println(moreThanHalfNum(nums1, nums1.length));
        System.out.println(moreThanHalfNum(nums2, nums2.length));
        System.out.println(moreThanHalfNum(nums2, nums2.length));
    }


}
