package com.coding_interiews.demo57;

/**
 * @author WJ
 * @date 2018/08/06
 * 面试题58B:和为s的连续正数序列（至少两个数）
 *
 * 题目：
 * 输入一个正数s，打印出所有和为s的连续正数序列
 */
public class Demo57B {

    private static void findContinuousSequence(int sum){
        if(sum < 3){
            return;
        }
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int currSum = small + big;
        while (small < middle){
            if(currSum == sum){
                pringContinuousSequence(small, big);
            }
            while (currSum > sum && small < middle){
                currSum -= small;
                small ++;

                if(currSum == sum){
                    pringContinuousSequence(small, big);
                }
            }
            big ++;
            currSum += big;
        }
    }

    private static void pringContinuousSequence(int small, int big){
        for(int i = small; i <= big ; i++){
            System.out.print(i +",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        findContinuousSequence(15);
        System.out.println("--------------");
        findContinuousSequence(20);
    }
}
