package com.example.demo64;

/**
 * @author WJ
 * @date 2018/08/11
 * 面试题64:求1+n+....+n
 * <p>
 * 题目:
 * 求 1+2+…+n。要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
 */
public class Demo64 {
    private static int sum(int n) {
        int sum = n;
        boolean bool = (n > 0) && ((sum += sum(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(5));
        System.out.println(sum(10));
        System.out.println(sum(100));
    }
}
