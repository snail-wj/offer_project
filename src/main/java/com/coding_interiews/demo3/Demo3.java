package com.coding_interiews.demo3;

/**
 * @author WJ
 * @date 2018/07/07
 * 题目三:数组中重复的数字
 *
 * 题目描述:
 *  在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *  数组中某些数字是重复的，但不知道有几个数字是重复的。
 *  也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *  例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 *
 * 时间复杂度：
 *  代码中尽管有一两个循环，但每一个数字最多只要交换两次就能找到
 *  属于自己的位置，因此总的时间复杂度是O(n)
 *
 * 解题思路:
 *  1.先判断数组是否正常(是否为空，以及是否数组中的元素是否有超过n-1)
 *  2.根据题目可知：如果数组不重复，那么arrays[i]=i
 *  3.我们通过循环，array[i]是否等于i，如果不等于，就将array[i]中的数字num和array[num]进行交换
 *  4.当我们最终交换的时候，如果发现交换的两个数字是相同的，这个就可以找出了相同的数字是什么
 */
public class Demo3 {

    public static void main(String[] args) throws Exception {
        int[] arrays = {4, 3, 1, 0, 2, 5, 3};
        int duplicateNum = duplicate(arrays);
        System.out.println("重复的数据为:" + (duplicateNum == -1 ? "null" : duplicateNum));
    }

    public static int duplicate(int[] arrays) throws Exception {
        if (arrays == null || arrays.length == 0) {
            throw new Exception("error input");
        }
        int length = arrays.length;

        for (int i = 0; i < length; i++) {
            if (arrays[i] < 0 || arrays[i] > length - 1) {
                throw new Exception("error arrays");
            }
        }

        for (int i = 0; i < length; i++) {
            while (arrays[i] != i){
                if (arrays[i] == arrays[arrays[i]]) {
                    return arrays[i];
                }
                int tmp = arrays[i];
                arrays[i] = arrays[tmp];
                arrays[tmp] = tmp;
            }
        }
        return -1;
    }
}
