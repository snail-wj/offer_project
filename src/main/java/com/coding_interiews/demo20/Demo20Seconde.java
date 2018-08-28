package com.coding_interiews.demo20;

import java.util.Arrays;
import java.util.List;

/**
 * @author WJ
 * @date 2018/07/17
 * 面试题20:表示数值的字符串
 */
public class Demo20Seconde {

    public boolean isNumberic(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        if (str.startsWith("+") || str.startsWith("-")) {
             str = str.substring(1);
        }
        if (str.length() == 0) {
            return false;
        }
        boolean numberic = true;
        str = scanDigits(str);
        if (str.length() != 0) {
            if (str.startsWith(".")) {
                str = str.substring(1);
                str = scanDigits(str);
                if (str.startsWith("e") || str.startsWith("E")) {
                    numberic = isExponential(str);
                }
            } else if (str.startsWith("e") || str.startsWith("E")) {
                numberic = isExponential(str);
            } else {
                numberic = false;
            }
        }
        return numberic;
    }

    /**
     * 判断数字部分
     * @param str
     * @return
     */
    public String scanDigits(String str) {
        char element = str.charAt(0);
        while (str.length() > 0 && element >= '0' && element <= '9') {
            str = str.substring(1);
            if (str.length() > 0) {
                element = str.charAt(0);
            }
        }
        return str;
    }

    /**
     * 判断指数部分
     * @param str
     * @return
     */
    public boolean isExponential(String str) {
        if (!str.startsWith("e")) {
            return false;
        }
        str = str.substring(1);
        if (str.startsWith("+") || str.startsWith("-")) {
            str = str.substring(1);
        }
        if (str.length() == 0) {
            return false;
        }
        str = scanDigits(str);
        return str.length() == 0 ? true : false;
    }

    public static void main(String[] args) {
        Demo20Seconde demo20 = new Demo20Seconde();
        List<Boolean> booleans1 = Arrays.asList(demo20.isNumberic("+100"), demo20.isNumberic("5e2"), demo20.isNumberic("-123"),
                demo20.isNumberic("3.1416"), demo20.isNumberic("-1E-16"), demo20.isNumberic("12e"),
                demo20.isNumberic("1a3.14"), demo20.isNumberic("12e+5.4"));
        for (Boolean b : booleans1) {
            System.out.println(b);
        }
    }

}
