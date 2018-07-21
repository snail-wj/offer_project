package com.example.demo27;

/**
 * @author WJ
 * @date 2018/07/21
 * 面试题27:二叉树的镜像
 *
 * 题目:
 * 请完成一个函数，输入一颗二叉树，该函数输出他的镜像
 */
public class Demo27 {
    public static void mirrorRecursively(BinaryTreeNode node){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            return;
        }
        BinaryTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        mirrorRecursively(node.left);
        mirrorRecursively(node.right);
    }

    public static String printBinaryTree(BinaryTreeNode node){
        String s = "";
        if(node == null){
            return s;
        }
        s += node.value + ",";
        s += printBinaryTree(node.left);
        s += printBinaryTree(node.right);
        return s;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(8);
        BinaryTreeNode root2 = new BinaryTreeNode(6);
        BinaryTreeNode root3 = new BinaryTreeNode(10);
        BinaryTreeNode root4 = new BinaryTreeNode(5);
        BinaryTreeNode root5 = new BinaryTreeNode(7);
        BinaryTreeNode root6 = new BinaryTreeNode(9);
        BinaryTreeNode root7 = new BinaryTreeNode(11);

        root1.setChildNode(root2, root3);
        root2.setChildNode(root4,root5);
        root3.setChildNode(root6,root7);

        System.out.println("镜像前的二叉树顺序:" + printBinaryTree(root1));
        mirrorRecursively(root1);
        System.out.println("镜像后的二叉树顺序:" + printBinaryTree(root1));

    }
}
