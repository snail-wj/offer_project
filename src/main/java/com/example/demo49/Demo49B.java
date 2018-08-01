package com.example.demo49;

/**
 * @author WJ
 * @date 2018/08/01
 * 面试题49:丑数 (方法2)
 *
 * 参考url:
 *  https://blog.csdn.net/u013309870/article/details/67012369
 */
public class Demo49B {

    private static int getUglyNumber(int index) {
        if (index == 0) {
            return 0;
        }

        int[] ugly = new int[index];
        ugly[0] = 1;
        int uglyIndex = 1, min;
        int nextIndex2 = 0, nexIndex3 = 0, nexIndex5 = 0;
        while (uglyIndex < index) {
            //min用于保存新产生的大于当前数组最大值的最小丑数
            min = ugly[nextIndex2] * 2 < ugly[nexIndex3] * 3 ? ugly[nextIndex2] * 2 : ugly[nexIndex3] * 3;
            min = min < ugly[nexIndex5] * 5 ? min : ugly[nexIndex5] * 5;
            ugly[uglyIndex] = min;
            while (ugly[nextIndex2] * 2 <= min){
                //如果ugly[nextIndex2]小于当前数组最大值的最小丑数 nextIndex2++
                nextIndex2 ++;
            }
            while (ugly[nexIndex3] * 3 <= min){
                //如果ugly[nextIndex3]小于当前数组的最大值的最小丑数， nextIndex3++
                nexIndex3 ++;
            }
            while (ugly[nexIndex5] * 5 <= min){
                //如果ugly[nextIndex5]小于当前数组的最大值的最小丑数， nextIndex5++
                nexIndex5 ++;
            }
            //uglyIndex++; 寻找下一个丑数
            uglyIndex ++;
        }
        return ugly[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(5));
        System.out.println(getUglyNumber(1500));
    }
}
