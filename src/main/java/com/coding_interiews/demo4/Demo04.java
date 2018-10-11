package com.coding_interiews.demo4;

/**
 * @author WJ
 * @date 2018/10/11
 * 面试题04: 二维数组中的查找
 *
 * 题目:在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class Demo04 {

    /**
     * @param matrix 待查找的数组
     * @param number 要查找的数
     * @return 查找结果: true找到， false没有找到
     */
    private static boolean find(int[][] matrix, int number) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        // 数组的行数
        int rows = matrix.length;
        // 数组的列数
        int cols = matrix[1].length;

        // 起始开始的行号
        int row = 0;
        // 起始开始的列号
        int col = cols - 1;

        // 要查找的位置保证在数组之内
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            //如果找到了，就直接退出
            if (matrix[row][col] == number) {
                return true;
            } else if (matrix[row][col] > number) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix, 7));
        System.out.println(find(matrix, 5));
    }
}
