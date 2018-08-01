package com.example.demo49;

/**
 * @author WJ
 * @date 2018/08/01
 * 面试题49:丑数(方法一)
 *
 * 题目:
 * 我们把只包含因子 2、3 和 5 的数称作为丑数（Ugly number）。求从小到大的顺序的第 1500 个丑数。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含了因子 7。习惯上，我们把 1 当做第一个丑数。
 *
 * 参考url:
 * https://blog.csdn.net/liyazhou0215/article/details/72812157
 */
public class Demo49_1 {

    private static int getUglyNumber(int k) {
        if (k < 1) {
            return -1;
        }
        for (int number = 1; ; number++) {
            if(isUgly(number)){
                k --;
            }
            if(k == 0){
                return number;
            }
        }
    }

    private static boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(5));
        System.out.println(getUglyNumber(1500));
    }

}
