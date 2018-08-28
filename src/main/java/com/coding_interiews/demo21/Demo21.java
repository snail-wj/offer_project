package com.coding_interiews.demo21;

/**
 * @author WJ
 * @date 2018/07/18
 * 面试题21::调整数组顺序使奇数位于偶数前面
 *
 * 题目:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 补充
 * &是二进制“与”运算，参加运算的两个数的二进制按位进行运算，运算的规律是：
 *       0 & 0=0
 *       0 & 1=0
 *       1 & 0=0
 *       1 & 1=1
 */
public class Demo21 {
    public static void recordOddeven(int[] data){
        if(data == null || data.length == 0){
            return;
        }

        int oddInd = 0, evenInd = data.length - 1;
        while (oddInd < evenInd){
            //向后移动oddInd查到指向偶数
            while ((data[oddInd] & 1) != 0){
                oddInd ++;
            }

            //向前移动evenInd知道指向奇数
            while ((data[evenInd]&1) ==0){
                evenInd --;
            }

            if(oddInd < evenInd){
                int temp = data[oddInd];
                data[oddInd] = data[evenInd];
                data[evenInd] = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("hello");
//        int[][] arr = {{1,2,3,4,5}, {2,4,6,1,3,5},{1,3,5,2,4,6}};
//        System.out.println(Arrays.deepToString(arr));
//        for (int i = 0; i < arr.length; i++){
//            recordOddeven(arr[i]);
//        }
//        System.out.println("调序后:" + Arrays.deepToString(arr));
    }
}
