package com.coding_interiews.demo63;

/**
 * @author WJ
 * @date 2018/08/11
 * 面试题63:股票的最大利润
 *
 * 题目:
 *  假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？
 */
public class Demo63 {

    private static int maxDiff(int[] numbers){
        if(numbers == null || numbers.length < 2){
            return 0;
        }
        int min = numbers[0];
        int maxDiff = numbers[1] - min;

        int length = numbers.length;
        for(int i = 2; i < length; i++){
            if(numbers[i-1] < min){
                min = numbers[i-1];
            }
            int currentDiff = numbers[i] - min;
            if(currentDiff > maxDiff){
                maxDiff = currentDiff;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] array1 = {9,11,5,5,7,12,16,14};
        int[] array2 = {3,4,5,9,11,0,5,7,22};
        int[] array3 = {3,3,3,3,3,3,3,3,3,2};
        System.out.println(maxDiff(array1));
        System.out.println(maxDiff(array2));
        System.out.println(maxDiff(array3));
    }
}
