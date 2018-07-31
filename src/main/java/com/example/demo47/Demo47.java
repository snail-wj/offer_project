package com.example.demo47;

/**
 * @author WJ
 * @date 2018/07/30
 * 面试题47:礼物的最大价值
 *
 * 题目:
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 */
public class Demo47 {

    public static int getMaxValue(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int rows = arr.length;
        int cols = arr[0].length;

        int[][] maxValue = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    //上面的值
                    up = maxValue[i - 1][j];
                }
                if (j > 0) {
                    //左面的值
                    left = maxValue[i][j - 1];
                }
                maxValue[i][j] = Math.max(up, left) + arr[i][j];
            }
        }
        return maxValue[rows -1][cols -1];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}
        };
        System.out.println(getMaxValue(arr));
    }
}
