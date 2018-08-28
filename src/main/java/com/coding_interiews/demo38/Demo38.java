package com.coding_interiews.demo38;

/**
 * @author WJ
 * @date 2018/07/27
 *面试题38：字符串的排列
 *
 * 题目:
 *  输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 参考url:
 *  https://blog.csdn.net/abc7845129630/article/details/52729835
 */
public class Demo38 {

    public static void swap(char[] arr, int index1, int index2) {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void permutation(char[] arr, int index, int size) {
        if (index == size) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        } else {
            for (int i = index; i < size; i++) {
                //我们从index向后扫描每一个字符（即指针i指向的字符），交换index和i指向的字符
                swap(arr, i, index);
                //对index后面的字符数组递归地做排列操作
                permutation(arr, index + 1, size);
                //每次递归固定要排列字符数组第一个字符不变
                swap(arr, i, index);
            }
        }
    }

    public static void main(String[] args) {
        char[] ch1 = {'a', 'b', 'c', 'd'};
        char[] ch2 = {'1', '2', '3'};
        permutation(ch1, 0, ch1.length);
        System.out.println("--------------------------");
        permutation(ch2, 0, ch2.length);
    }
}
