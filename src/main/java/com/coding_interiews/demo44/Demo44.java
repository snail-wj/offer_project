package com.coding_interiews.demo44;

/**
 * @author WJ
 * @date 2018/07/29
 * 面试题44:数字序列中某一位的数字
 *
 * 题目:
 *  数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，
 *  第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一个函数求任意位对应的数字。
 *
 * 时间复杂度
 *  O(logn)
 *
 * 参考url:
 *  https://blog.csdn.net/m0_37862405/article/details/80341260
 */
public class Demo44 {

    public static int digitAtIndex(int index){
        if(index < 0){
            return  -1;
        }
        int digits = 1;
        while (true){
            //当前位数的数值个数
            int digitNumber = countOfNumbersFor(digits);
            //数值乘上它的位数等于数字的个数
            //比如，两位数有90个(10~99)，每一个数值有2个数字，总数字个数为180
            int countOfNumber = digitNumber * digits;
            if(index < countOfNumber){
                return digitAtIndex(index, digits);
            }else {
                //在下一位中查找
                index -= countOfNumber;
                digits ++;
            }
        }
    }

    //digits位数的数字个数
    //两位数有9*10=90个(10~99),三位数字有9*100=900个(100~999)
    public static int countOfNumbersFor(int digits){
        if(digits == 1){
            return 10;
        }
        int count = (int)Math.pow(10, digits - 1);
        return 9* count;
    }

    public static int digitAtIndex(int index, int digits){
        //对应的数值
        int number = beginNumberFor(digits) + index / digits;
        //从数值右边的indexromRight-1个数字
        int indexFromRight = digits - index % digits;
        for(int i = 1; i < indexFromRight; i++){
             number /= 10;
        }
        //求个位数字
        return number % 10;
    }

    //digits位数的第一个数字，两位数从10开始，三位数从100开始
    public static int beginNumberFor(int digits){
        if(digits == 1){
            return 0;
        }
        return (int)Math.pow(10, digits -1);
    }

    public static void main(String[] args) {
        System.out.println(digitAtIndex(9));
        System.out.println(digitAtIndex(189));
        System.out.println(digitAtIndex(1001));
    }
}
