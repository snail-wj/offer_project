package com.example.demo49;

/**
 * @author WJ
 * @date 2018/08/01
 * 面试题49:丑数 (方法2)
 *
 * 参考url:
 *  https://blog.csdn.net/u013309870/article/details/67012369
 */
public class Demo49_2 {

    public static int getUglyNumber(int index) {
        if (index == 0) {
            return 0;
        }

        int[] urgly = new int[index];
        urgly[0] = 1;
        int urglyIndex = 1, min = 0;
        int nextIndex2 = 0, nexIndex3 = 0, nexIndex5 = 0;
        while (urglyIndex < index) {
            //min用于保存新产生的大于当前数组最大值的最小丑数
            min = urgly[nextIndex2] * 2 < urgly[nexIndex3] * 3 ? urgly[nextIndex2] * 2 : urgly[nexIndex3] * 3;
            min = min < urgly[nexIndex5] * 5 ? min : urgly[nexIndex5] * 5;
            urgly[urglyIndex] = min;
            while (urgly[nextIndex2] * 2 <= min){
                //如果urgly[nextIndex2]小于当前数组最大值的最小丑数 nextIndex2++
                nextIndex2 ++;
            }
            while (urgly[nexIndex3] * 3 <= min){
                //如果urgly[nextIndex3]小于当前数组的最大值的最小丑数， nextIndex3++
                nexIndex3 ++;
            }
            while (urgly[nexIndex5] * 5 <= min){
                //如果urgly[nextIndex5]小于当前数组的最大值的最小丑数， nextIndex5++
                nexIndex5 ++;
            }
            //urglyIndex++; 寻找下一个丑数
            urglyIndex ++;
        }
        return urgly[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(5));
        System.out.println(getUglyNumber(1500));
    }
}
