package com.example.demo19;

import java.util.Arrays;
import java.util.List;

/**
 * @author WJ
 * @date 2018/07/16
 * 面试题20: 表示数字的字符串
 *
 * 题目:
 * 请实现一个函数用来判断字符串是否表示数值(包括整数和小数)
 *
 * 描述:
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
 */
public class Demo20First {

    /**
     * 用try-catch来实现
     *
     * @param str
     * @return
     */
    public boolean isNumeric_1(String str) {
        try {
            Double.parseDouble(new String(str));
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    /**
     * 正则表达式
     *
     * @param str
     * @return
     */
    public boolean isNumeric_2(String str) {
        return str.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }


    public static void main(String[] args) {
        Demo20First demo20 = new Demo20First();
        List<Boolean> booleans1 = Arrays.asList(demo20.isNumeric_1("+100"), demo20.isNumeric_1("5e2"), demo20.isNumeric_1("-123"),
                demo20.isNumeric_1("3.1416"), demo20.isNumeric_1("-1E-16"), demo20.isNumeric_1("12e"),
                demo20.isNumeric_1("1a3.14"), demo20.isNumeric_2("12e+5.4"));
        for(Boolean b : booleans1){
            System.out.println(b);
        }

        System.out.println("-------------------------------");
        List<Boolean> booleans2 = Arrays.asList(demo20.isNumeric_2("+100"), demo20.isNumeric_2("5e2"), demo20.isNumeric_2("-123"),
                demo20.isNumeric_2("3.1416"), demo20.isNumeric_2("-1E-16"), demo20.isNumeric_2("12e"),
                demo20.isNumeric_2("1a3.14"), demo20.isNumeric_2("12e+5.4"));
        for(Boolean b : booleans2){
            System.out.println(b);
        }
    }
}
