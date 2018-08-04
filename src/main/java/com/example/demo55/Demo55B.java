package com.example.demo55;

/**
 * @author WJ
 * @date 2018/08/04
 * 面试题55:二叉树的深度(题目2:判断一颗树是否是平衡二叉树)
 *
 * 题目:
 *  输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 缺点:
 *  调用isBalance(BinaryTreeNode root)的时候，我们由于要判断每一个节点是否是
 *  平衡二叉树的节点，所以我们要重复的计算相同节点的深度，通过treeDepth()方法
 */
public class Demo55B {

    private static int treeDepth(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (left > right) ? left + 1: right + 1;
    }

    private static boolean isBalance(BinaryTreeNode root){
        if(root == null){
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        int diff = left -right;
        if(diff > 1 || diff < -1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }

    public static void main(String[] args) {
        System.out.println(isBalance(constructorNode1()));
        System.out.println(isBalance(constructorNode2()));
    }

    private static BinaryTreeNode constructorNode1(){
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

        return root1;
    }

    private static BinaryTreeNode constructorNode2(){
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode root3 = new BinaryTreeNode(3);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root5 = new BinaryTreeNode(5);
        BinaryTreeNode root6 = new BinaryTreeNode(6);
        BinaryTreeNode root7 = new BinaryTreeNode(7);

        root1.setChildNode(root2,root3);
        root2.setRightChildNode(root5);
        root3.setRightChildNode(root6);
        root5.setLeftChildNode(root7);
        return root1;
    }
}
