package com.coding_interiews.demo45;

import java.util.*;

/**
 * @author WJ
 * @date 2018/07/29
 *
 * 面试题45:把数组排成最小的数
 *
 * 题目:
 *  输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个，
 *  例如输入数组 {3, 32, 321}，则打印出这 3 个数字能排成的最小数字 321323。
 *
 * 参考url:
 *  https://blog.csdn.net/liyazhou0215/article/details/72809323
 */
public class Demo45 {

    public static String printMinNumber(int[] numbers) {

        Integer[] array = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = numbers[i];
        }
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //代表o1放在前面
                int num1 = Integer.valueOf("" + o1 + o2);
                //代表o2放在前面
                int num2 = Integer.valueOf("" + o2 + o1);
                int result = 0;
                //升序排序，o1+o2较大，则o1放在后面
                if (num1 > num2) {
                    result = 1;
                }
                //升序排序，o1+o2较小，则o1放在前面
                else if(num1 < num2){
                    result = -1;
                }
                return result;
            }
        };
        Arrays.sort(array, cmp);
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            s.append(array[i]);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        int[] array1 = {3,32,321};
        int[] array2 = {2,13,45,25};
        int[] array3 = {3,32,321,1,12};
        System.out.println(printMinNumber(array1));
        System.out.println(printMinNumber(array2));
        System.out.println(printMinNumber(array3));
    }

}
