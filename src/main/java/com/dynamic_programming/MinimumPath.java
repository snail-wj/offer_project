package com.dynamic_programming;

/**
 * @author WJ
 * @date 2018/08/30
 * 动态规划问题:矩阵最小路径和问题
 * 题目:有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和
 */
public class MinimumPath {
    private static int getMin(int[][] map, int n, int m) {
        if (map == null || n <= 0 || m <= 0) {
            return 0;
        }
        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];

        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = map[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] array = {{1, 10, 1, 1, 1}, {1, 1, 1, 10, 1}};
        System.out.println(getMin(array, 2, 5));
    }
}
