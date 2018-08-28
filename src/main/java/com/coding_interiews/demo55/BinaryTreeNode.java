package com.coding_interiews.demo55;

/**
 * @author WJ
 * @date 2018/08/04
 */
public class BinaryTreeNode {
    public int nodeValue;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public void setLeftChildNode(BinaryTreeNode left){
        this.left = left;
    }

    public void setRightChildNode(BinaryTreeNode right){
        this.right = right;
    }

    public void setChildNode(BinaryTreeNode left, BinaryTreeNode right){
        this.left = left;
        this.right = right;
    }

}
