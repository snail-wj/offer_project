package com.example.demo61;

/**
 * @author WJ
 * @date 2018/08/10
 *
 * 面试题44:扑克牌的顺子
 *
 * 题目:
 *  从扑克牌中随机抽 5 张牌，判断是不是顺子，即这 5 张牌是不是连续的。
 *  2~10为数字本身， A 为 1，J 为 11，Q 为 12，K 为13，而大、小王可以看成任意数字。
 *
 * 参考url:
 * https://blog.csdn.net/liyazhou0215/article/details/72854288
 */
public class Demo61 {

    private static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }

        //冒泡选择
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }

        //统计大小王的个数
        int counter = 0;
        for (int i = 0; i < 2; i++) {
            if (numbers[i] == 0) {
                counter++;
            }
        }

        int totalDiff = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] == 0) {
                continue;
            }
            int diff = numbers[i] - numbers[i - 1];
            if (diff == 0) {
                return false;
            }
            totalDiff += (diff - 1);
            if(totalDiff > counter){
                return false;
            }
        }
        return totalDiff <= counter;
    }

    public static void main(String[] args) {
        int[] array1= {1,9,5,8,0};
        int[] array2 = {8,5,0,0,4};
        int[] array3 = {9,10,7,0,12};
        System.out.println(isContinuous(array1));
        System.out.println(isContinuous(array2));
        System.out.println(isContinuous(array3));
    }
}
