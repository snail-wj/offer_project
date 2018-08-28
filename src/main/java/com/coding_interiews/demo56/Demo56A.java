package com.coding_interiews.demo56;

import java.util.Arrays;

/**
 * @author WJ
 * @date 2018/08/05
 *
 * 面试题56:数组中出现的次数
 */
public class Demo56A {

    //TODO 这个需要看一下
    private static int[] findTwoNumOfApperanceOnce(int[] array) {
        int[] result = {0, 0};

        if (array == null || array.length < 2) {
            return result;
        }
        int xor = 0;
        for (int emt : array) {
            xor ^= emt;
        }

        // int indexOfOne = findFirstBit1(xor);
        String xorStr = Integer.toBinaryString(xor);
        //从右面开始计数，0是第一个数字
        int indexOfOne = xorStr.length() - xorStr.lastIndexOf("1") - 1;
        for (int emt : array) {
            // 如果这个数组的倒数第indexOfOne+1个数字是1，则划分到一个数组中，否则划分到另一个数组中
            // 出现两次的数字同时被分配到哪一个数组是无关紧要的
            // 我们的目的是将只出现一次的两个数字划分到两个数组中
            if (((emt >>> indexOfOne) & 1) == 1) {
                result[0] ^= emt;
            } else {
                result[1] ^= emt;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {2,4,3,6,3,2,5,5};
        int[] array2 = {4,5};
        int[] array3 = {4,4,5,5,1,2};
        System.out.println(Arrays.toString(findTwoNumOfApperanceOnce(array1)));
        System.out.println(Arrays.toString(findTwoNumOfApperanceOnce(array2)));
        System.out.println(Arrays.toString(findTwoNumOfApperanceOnce(array3)));
    }
}
