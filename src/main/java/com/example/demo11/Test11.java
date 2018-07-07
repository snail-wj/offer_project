package com.example.demo11;

/**
 * @author WJ
 * @date 2018/07/07
 *
 *  * 面试题 8：旋转数组的最小数字
 * 题目：
 *      把一个数组的最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
 *      输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *      例如，数组 {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 * 思路：
 *      1. 二分查找（双指针，确定边界）
 *      2. 初始时，A 指针指向第一个元素，B 指针指向最后一个元素;
 *              两个指针分别从开头和末尾向中间移动，直到指向同一个位置
 *         两个指针所在的下标之和折半，
 *              若该元素大于 B 指针指向的元素，则该元素属于第一个递增子数组，
 *                  最小值位于折半位置和 B 指针之间，所以将 A 指向折半后的位置
 *              若该元素小于 B 指针指向的元素，则该元素属于第二个递增子数组，
 *                  最小值位于 A 指针和折半位置之间，所以将 B 指向折半后的位置
 *         当 A 指针和 B 指针位置相同时，它们指向的元素就是最小值
 *
 *
 * 思路2：
 *      1. 二分查找（双指针，确定边界）
 *      2. 初始时，A 指针指向第一个元素，B 指针指向最后一个元素;
 *              两个指针分别从开头和末尾向中间移动，直到指向同一个位置
 *         两个指针所在的下标之和折半得到指针 mid，
 *              若A、B 和 mid 三者指向的元素相等，
 *                  则无法判断 mid 指向的元素属于第一个还是第二个递增子数组，所以顺序查询最小元素
 *              若该元素大于等于 A 指针指向的元素，
 *                  则该元素属于第一个递增子数组，最小值位于折半位置和 B 指针之间，所以将 A 指向折半后的位置
 *              若该元素小于等于 B 指针指向的元素，
 *                  则该元素属于第二个递增子数组，最小值位于 A 指针和折半位置之间，所以将 B 指向折半后的位置
 *         当 A 指针和 B 指针位置相同时，它们指向的元素就是最小值
 */
public class Test11 {
    public static void main(String[] args) throws Exception {
        int[] arrays1 = {3, 4, 5, 1, 2};
        int[] arrays2 = {1, 0, 1, 1, 1};
        int[] arrays3 = {1, 0};
        int minIndex = min(arrays1);
        System.out.println(arrays1[minIndex]);
    }

    public static int min(int[] arrrays) throws Exception {
        //判断输入
        if (arrrays == null && arrrays.length <= 0) {
            throw new Exception("error input array");
        }

        int index1 = 0;
        int index2 = arrrays.length - 1;
        int minIndex = 0;
        while (arrrays[index1] >= arrrays[index2]) {

            if (index2 - index1 == 1) {
                minIndex = index2;
                break;
            }

            //first和second对半
            minIndex = (index1 + index2) / 2;

            if(arrrays[index1] == arrrays[index2] && arrrays[index1] == arrrays[minIndex]){
             return minIndexOrder(arrrays, index1, index2);
            }

            if (arrrays[minIndex] >= arrrays[index1]) {
                index1 = minIndex;
            } else if (arrrays[minIndex] <= arrrays[index2]) {
                index2 = minIndex;
            }

        }
        return minIndex;
    }

    public static int minIndexOrder(int[] arrrays, int index1, int index2) {
        int minIndex = index1;
        for (int i = index1; i <= index2; i++){
            if(arrrays[minIndex] > arrrays[i]){
                minIndex = i;
            }
        }
        return minIndex;
    }
}
