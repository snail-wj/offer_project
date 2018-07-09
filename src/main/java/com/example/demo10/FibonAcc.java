package com.example.demo10;

/**
 * @author WJ
 * @date 2018/07/06
 *
 * 面试题 10：斐波那契数列
 * 题目一：
 *      写一个函数，输入 n，求斐波那契 (Fibonacci)数列的第 n 项。斐波那契数列的定义如下：
 *          f(n) = 0,                   n = 0
 *          f(n) = 1,                   n = 1
 *          f(n) = f(n-1) + f(n-2),     n > 1
 *
 * 思路：
 *      1. 当 n = 0 或 1 时，返回 n
 *      2. 当 n > 1 时，返回前两项元素之和。使用循环实现
 *
 *
 * 题目二：
 *      一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级台阶。
 *      求该青蛙跳上一个 n 级台阶总共有多少种跳发。
 *
 * 思路：
 *      1. 本质就是斐波那契数列，使用递归思想解题
 *      2. 如果只有 1 级台阶，结果只有一种跳法；
 *         如果只有 2 级台阶，结果有两种跳法；
 *         如果台阶阶数为n，n 大于 2时，第一次跳有两种不同的选择，
 *         一是先跳一级台阶，则总的跳法数目为后面 n-1 级台阶的跳法数目；
 *         二是先跳二级台阶，则总的跳法数目为后面 n-2 级台阶的跳法数目
 *
 * 题目三:
 *      想对公司员工的年龄进行一个排序，公司的人数是几万名员工，时间复杂度是O(n)
 *
 * 思路:
 *      1.可以使用最笨的办法，使用暴力的方法
 *        使用时间复杂度为O(n^2),每一次遍历找出最小的年龄，并把当前最小的年龄记录下来
 *        不过使用这种方法太笨了
 *      2.如果我可以确定下来一个公司的年龄分布，我先O(n)得出各个年龄的人数
 *        接下来只需要把各个年龄的人按序输出即可
 */
public class FibonAcc {

    /**
     * 效率很低的解法，挑剔的面试官不会喜欢
     * @param n
     * @return
     * @throws Exception
     */
    public static int fibonacciUsingRecursion(int n) throws Exception {
        if (n < 0) {
            throw new Exception("n is error input");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciUsingRecursion(n - 1) + fibonacciUsingRecursion(n - 2);
    }

    /**
     * 面试官期待的使用解法，时间复杂度是O(n)
     * @param n
     * @return
     * @throws Exception
     */
    public static int fibonacci(int n) throws Exception {
        if (n < 0) {
            throw new Exception("n is error input");
        } else if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        int tmp = -1;
        for (int i = 1; i < n; i++) {
            tmp = second;
            second += first;
            first = tmp;
        }
        return second;
    }

    public static int frogSolution(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("error input !");
        }
        int first = 1;
        int second = 2;
        int tmp = -1;
        for (int i = 3; i <= n; i++) {
            tmp = second;
            second += first;
            first = second;
        }
        return second;
    }

    /**
     * 使用了100的整数数组作为辅助空间换来的O(n)的时间效率
     * @param ages
     * @param length
     * @return
     * @throws Exception
     */
    public static int[] sortAgs(int[] ages, int length) throws Exception {
        if(ages == null || length <= 0){
            throw new Exception("error input");
        }
        final int oldestAge = 99;
        int[] timesOfAge = new int[100];
        for (int i = 1; i <= oldestAge ; i++){
            timesOfAge[i] = 0;
        }
        for(int i = 0; i < length; i++){
            int age = ages[i];
            if(age > oldestAge || age <= 0){
                throw new Exception("age is Error");
            }

            ++ timesOfAge[age];
        }

        int index = 0;
        for(int i = 0; i <= oldestAge; i++){
            for (int j = 0; j < timesOfAge[i]; j ++){
                ages[index] = i;
                index ++;
            }
        }
        return ages;
    }


    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 1000; i++) {
            System.out.println("fibonacciUsingRecursion :" + fibonacciUsingRecursion(i));
            System.out.println("fibonacci :" + fibonacci(i));
            System.out.println();
        }
    }
}
