package com.coding_interiews.demo55;

/**
 * @author WJ
 * @date 2018/08/04
 * 面试题55:二叉树的深度
 *
 * 题目:
 * 输入一棵二叉树的根节点，求该数的深度。从根节点到叶结点依次进过的结点（含根，叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度
 */
public class Demo55A {
    private static int treeDepth(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (left > right) ? left + 1: right + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode root3 = new BinaryTreeNode(3);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root5 = new BinaryTreeNode(5);
        BinaryTreeNode root6 = new BinaryTreeNode(6);
        BinaryTreeNode root7 = new BinaryTreeNode(7);

        root1.setChildNode(root2,root3);
        root2.setChildNode(root4,root5);
        root3.setRightChildNode(root6);
        root5.setLeftChildNode(root7);
        System.out.println();
        System.out.println(treeDepth(root1));
    }
}
