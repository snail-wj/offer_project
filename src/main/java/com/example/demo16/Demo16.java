package com.example.demo16;

/**
 * @author WJ
 * @date 2018/07/11
 * 面试题16：数值的整数次方
 *
 * 题目:
 *      实现函数 double Power(double base, int exponent)，求 base 的 exponent 次方。
 *      不得使用库函数，同时不需要考虑大数问题
 *
 * 问题：
 *   1. 指数 exponent可能为 0 或者负数
 *   2. 底数为 0 的特殊情况, 0^0 = 1，0^n = 0
 *   3. 判断 double 型底数是否为 0，虽然double 类型不是精确类型，但是Java语言支持使用等号判断
 *
 * 思路：
 *   1.exponent == 0, 返回 1
 *   2. base == 0, 返回 0
 *   3. base!=0, exponent < 0, 累乘 1/base abs(exponenet)次
 *   4. base!=0, exponent > 0, 累乘 1/base exponent 次
 */
public class Demo16 {

    /**
     * 一般做法
     * @param base          底数
     * @param exponent      幂次，指数
     * @return              幂运算结果
     */
    private double power(double base, int exponent){
        if(equals(base, 0.0)){
            return 0.0;
        }
        //任何数的0次幂都是1
        if(equals(exponent, 0.0)){
            return 1.0;
        }

        if(exponent < 0){
            base = 1 / base;
            exponent = -exponent;
        }
        return powerWithPositiveExponent(base, exponent);
    }

    /**
     * 优化的方法，折半的思想，可以减少，ags(exponent)/2次播放
     * 如果exponent较大，可以多次折半
     * @param base          底数
     * @param exponent      幂次，指数
     * @return              幂运算结果
     */
    private double power2(double base, int exponent){
        if(equals(base, 0)) {
            return 0;
        }

        if(equals(exponent, 0)){
            return 1.0;
        }

        if(exponent < 0){
            base = 1 / base;
            exponent = -exponent;
        }

        //折半计算，减少循环次数
        double result = powerWithPositiveExponent(base, exponent >> 1);
        result *= result;
        //按位与1，判断整数位奇数还是偶数
        if((exponent & 1) == 1){
            result *= base;
        }
        return result;
    }

    private double powerWithPositiveExponent(double base, int exponent){
        double result = 1.0;
        for (int i = 0; i < exponent; i++){
            result *= base;
        }
        return result;
    }


    private boolean equals(double a, double b){
        if((a - b) > -1E-5 && (a -b ) < 1E-5){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Demo16 demo16 = new Demo16();
        System.out.println(demo16.power(3, -3));
        System.out.println(demo16.power(2, 3));
        System.out.println(demo16.power2(3, -3));
        System.out.println(demo16.power2(2, 3));
    }
}
