package com.example.demo12;

/**
 * @author WJ
 * @date 2018/07/07
 * <p>
 * 面试题12:矩阵中的路径
 * 参考文章:https://blog.csdn.net/DERRANTCM/article/details/46887767
 */
public class Demo12 {

    /**
     * @param matrix 输入矩阵
     * @param rows   矩阵行数
     * @param cols   矩阵列数
     * @param str    要搜索的字符串
     * @return 是否能找到 true是， false 否
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 参数校验
        if (matrix == null || matrix.length != rows * cols || str == null || str.length < 1) {
            return false;
        }

        //变量初始化
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        //记录结果的数组;
        int[] pathLength = {0};
        //以每一个点为起点进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, str, visited, i, j, pathLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 回溯搜索算法
     *
     * @param matrix     输入矩阵
     * @param rows       矩阵行数
     * @param cols       矩阵列数
     * @param str        要搜索的字符串
     * @param visited    访问标记数组
     * @param row        当前的行数
     * @param col        当前的列数
     * @param pathLength 已经处理的str中字符的个数
     * @return 是否找到 true是，false否
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str,
                                        boolean[] visited, int row, int col, int[] pathLength) {

        //这个不是一下子就返回第37行，还是会通过return hasPath返回
        if (pathLength[0] == str.length) {
            return true;
        }

        boolean hashPath = false;

        // 判断位置是否合适
        //在根据行和列判断当前的字符串的时候，是行*一共有多少列+当前列
        if (row >= 0 && row < rows
                && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength[0]]
                && !visited[row * cols + col]) {

            visited[row * cols + col] = true;
            pathLength[0] ++;

            //按左上右下进行回溯
            hashPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength);

            if (!hashPath) {
                pathLength[0]--;
                visited[row * cols + col] = false;
            }

        }

        //下面的注释打开的，就会报错，是因为当满足条件的时候，返回true，也会经过
        //下面的代码，如果输入str[length]就会有问题
//        if (row >= 0 && row < rows
//                && col >= 0 && col < cols) {
//            System.out.println("row:" + row + " col:" + col + "是" + hashPath + ",matrix[row * col + col]:" + matrix[row * cols + col] + ",str[pathLength[0]:" + str[pathLength[0]] + ",visited[row * col + col]:" + visited[row * cols + col]);
//        }
        return hashPath;
    }

    public static void main(String[] args) {
        //ABCE  //ABCCED
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray()));


        //ABCE  //ABCB
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABCB".toCharArray()) + "[false]");// false

        //ABCEHJIG  //SLHECCEIDEJFGGFIE
        //SFCSLOPQ
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SLHECCEIDEJFGGFIE".toCharArray()) + "[true]");// true
    }
}
