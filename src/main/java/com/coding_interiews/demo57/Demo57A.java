package com.coding_interiews.demo57;

/**
 * @author WJ
 * @date 2018/08/06
 *
 * 面试题57A:和为s的两个数字
 * 题目:
 *  输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S,则输入任意一对即可
 */
public class Demo57A {

    private static int num1;
    private static int num2;

    private static boolean findNumbersWithSum(int[] data, int sum){
        boolean found = false;
        if(data == null || data.length < 2 ){
            return false;
        }
        int ahead = data.length - 1;
        int behind = 0;
        while (ahead > behind){
            long curSum = data[behind] + data[ahead];
            if(curSum == sum){
                num1 = data[behind];
                num2 = data[ahead];
                found = true;
                break;
            }
            else if(curSum > sum){
                ahead --;
            }else {
                behind ++;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,4,7,11,15};
        if(findNumbersWithSum(array1, 15)){
            System.out.println(num1 + "," + num2);
        }
        int[] array2 = {2,4,6,8,10,12,14};
        if(findNumbersWithSum(array2, 16)){
            System.out.println(num1+ "," + num2);
        }
        if(findNumbersWithSum(array2, 30)){
            System.out.println(num1 + "," + num2);
        }
    }
}
