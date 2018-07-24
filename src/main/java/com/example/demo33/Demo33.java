package com.example.demo33;

/**
 * @author WJ
 * @date 2018/07/24
 * 面试题33:二叉搜索树的后序遍历序列
 *
 * 题目
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *  如果是则返回 true，否则返回 false。
 *  假设输入的数组的任意两个数字都互不相同。
 *
 *  参考url:
 *   https://blog.csdn.net/liyazhou0215/article/details/72792763
 */
public class Demo33 {
    public static boolean vertifySeqOfBST(int[] postorder, int start, int end) {
        if (postorder == null) {
            return false;
        }

        int split;
        for (split = start; split < end - 1; split++) {
            if (postorder[split] > postorder[end - 1]) {
                break;
            }
        }

        //递归终止条件
        //如果根节点比其右孩子大，则返回false
        for (int i = split; i < end; i++) {
            if (postorder[i] < postorder[end - 1]){
                return false;
            }
        }

        boolean left = true;
        //有条件的递归,其递归终止条件split <= start
        if (split > start) {
            left = vertifySeqOfBST(postorder, start, split - 1);
        }

        boolean right = true;
        //有条件递归，其递归终止条件是 split >= end -1
        if (split < end - 1) {
            right = vertifySeqOfBST(postorder, split, end - 1);
        }
        return left && right;
    }

    public static void main(String[] args) {
        int[][] seqs = {{5, 7, 6, 9, 11, 10, 8}, {5, 7, 6, 9, 11, 5, 8}};
        for (int i = 0; i < seqs.length; i++) {
            System.out.println(vertifySeqOfBST(seqs[i], 0, seqs[i].length));
        }
    }
}
