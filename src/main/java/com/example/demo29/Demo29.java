package com.example.demo29;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WJ
 * @date 2018/07/21
 * 面试题:29 s顺时针打印矩阵
 *
 * 题目:
 *  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 *  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 参考文章:
 * https://blog.csdn.net/qq_32261399/article/details/76616895
 */
public class Demo29 {

    public static List printMatrixInCircle(int[][] arr) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        int column = arr[0].length;
        int line = arr.length;
        if (column == 0 || line == 0) {
            return null;
        }
        int start = 0;
        while (column > start * 2 && line > start * 2) {
            int endX = column - 1 - start;
            int endY = line - 1 - start;

            //从左向右打印一行
            for(int i = start; i <= endX ; i++){
                arrayList.add(arr[start][i]);
            }

            //从上到下打印一列
            if(start < endY){
                for(int i = start + 1; i <= endY; i++){
                    arrayList.add(arr[i][endX]);
                }
            }

            //从右到左
            if(start < endX && start < endY){
                for (int i = endX -1; i >= start; --i){
                    arrayList.add(arr[endY][i]);
                }
            }

            //从下到上
            if(start < endX && start < endY -1){
                for(int i = endY -1; i > start; --i){
                    arrayList.add(arr[i][start]);
                }
            }

            start ++;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int array[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
        System.out.println(printMatrixInCircle(array));
    }
}
