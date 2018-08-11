package com.example.demo65;

/**
 * @author WJ
 * @date 2018/08/11
 * 面试题65:不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷四则运算符号。
 *
 * 异或(^):
 *  1 ^ 1 = 0;
 *  0 ^ 0 = 0;
 *  1 ^ 0 = 1;
 *  0 ^ 1 = 1;
 *
 * 与(&):
 *  1 & 1 = 1;
 *  0 & 0 = 0;
 *  1 & 0 = 0;
 *  0 & 1 = 0;
 *  位与:第一个操作数的第n位与第二个操作数的第n位，如果都是1，那么位与的结果都是1
 */
public class Demo65 {
    private static int add(int num1, int num2){
        int sum = 0, carry = -1;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while (num2 != 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add(5,4));
        System.out.println(add(0,0));
        System.out.println(add(1,-2));
    }
}
