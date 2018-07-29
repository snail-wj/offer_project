package com.example.demo43;

/**
 * @author WJ
 * @date 2018/07/29
 *
 * 面试题43:1~n整数中1出现的次数（第一种方法，时间复杂uO（n62））
 */
public class Demo43 {

    public static int countNumOfOne(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            for (int number = i; number != 0; number /= 10) {
                if (number % 10 == 1) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(countNumOfOne(11));
        System.out.println(countNumOfOne(12));
        System.out.println(countNumOfOne(20));

    }
}
