package com.coding_interiews.demo36;

/**
 * @author WJ
 * @date 2018/07/26
 */
public class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public void setChild(BinaryTreeNode left, BinaryTreeNode right){
        this.left = left;
        this.right = right;
    }
}
