package com.coding_interiews.demo54;

import org.omg.CORBA.INTERNAL;

/**
 * @author WJ
 * @date 2018/08/04
 * 面试题54：二叉搜索树的第k大节点
 *
 * 二叉搜索树:又名二叉排序树,若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
 *
 * 题目:
 *  给定一颗二叉搜索树，请找出其中的第k大的结点。
 *
 * 参考url:
 *  https://blog.csdn.net/u011080472/article/details/51290909
 */
public class Demo54 {

    //排序操作
    private static String printBinaryTreeNode(BinaryTreeNode root){
        String s = "";
        if(root == null){
            return null;
        }
        if(root.left != null){
            s += printBinaryTreeNode(root.left);
        }
        s += (root.value + ",");
        if(root.right != null){
            s += printBinaryTreeNode(root.right);
        }
        return s;
    }

    private static int KthNode(BinaryTreeNode root, int target){
        if(root == null){
            return -1;
        }
        String serialToString = printBinaryTreeNode(root);
        String[] values = serialToString.split(",");
        return Integer.valueOf(values[target - 1]);
    }


    public static void main(String[] args) {
        BinaryTreeNode root5 = new BinaryTreeNode(5);
        BinaryTreeNode root3 = new BinaryTreeNode(3);
        BinaryTreeNode root7 = new BinaryTreeNode(7);
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root6 = new BinaryTreeNode(6);
        BinaryTreeNode root8 = new BinaryTreeNode(8);

        root5.setChild(root3, root7);
        root3.setChild(root2,root4);
        root7.setChild(root6,root8);

        System.out.println(KthNode(root5, 5));
    }
}
