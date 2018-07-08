package com.example.demo13;

/**
 * @author WJ
 * @date 2018/07/08
 * 面试题13：机器人的运行范围
 *
 * 题目：地上有个m行n列的方格。一个机器人从坐标(0,0)的格子开始移动，
 * 它每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数
 * 位之和大于k的格子。例如，当k为18时，机器人能够进入方格(35,37)，
 * 因为3+5+3+7=18.但它不能进入方格(35,38)，因为3+5+3+8=19.
 * 请问该机器人能够达到多少格子？
 *
 */
public class  Demo13 {

    /**
     *
     * @param threshold 约束值
     * @param rows      方格的行数
     * @param cols      方格的列数
     * @return          最多可以走的方格
     */
    private int movingCount(int threshold, int rows, int cols){

        //这个rows和cols是从1开始的，并不是从0开始的
        if(threshold < 0 || rows == 0 || cols ==0){
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++){
            visited[i] = false;
        }

        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;

    }

    /**
     * 递归回溯方法
     * @param threshold     约束值
     * @param rows          方格的行数
     * @param cols          方格的列数
     * @param row           当前处理的行号
     * @param col           当前处理的列号
     * @param visited       访问标记数组
     * @return              最多可走的方格
     */
    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        int count = 0;
        if(check(threshold, rows, cols, row, col, visited)){
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row, col - 1, visited) +
                    movingCountCore(threshold, rows, cols, row - 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row, col + 1, visited) +
                    movingCountCore(threshold, rows, cols, row + 1, col, visited);
        }
        return count;
    }

    /**
     * 机器人能否进入坐标为(row, col)的方格
     *
     * @param threshold     约束值
     * @param rows          方格的行数
     * @param cols          方格的列数
     * @param row           当前处理的行号
     * @param col           当前处理的列号
     * @param visited       访问标记数组
     * @return
     */
    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited){
        if(row >= 0 && row < rows &&
                col >= 0 && col < cols &&
                getDigitSum(row) + getDigitSum(col) <= threshold &&
                !visited[row*cols +col]){
            return true;
        }
        return false;
    }

    /**
     * 一个数字的数位之和
     * @param number 数字
     * @return 数字的数位之和
     */
    private int getDigitSum(int number){
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Demo13 demo = new Demo13();
        System.out.println(demo.movingCount(5, 10, 10) + "[21]");
        System.out.println(demo.movingCount(15, 20, 20) + "[359]");
        System.out.println(demo.movingCount(3, 3, 4) + "[9]");
        System.out.println(demo.movingCount(3, 1, 10) + "[9]");
    }

}
