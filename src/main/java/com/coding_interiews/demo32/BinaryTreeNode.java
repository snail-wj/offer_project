package com.coding_interiews.demo32;

/**
 * @author WJ
 * @date 2018/07/23
 */
public class BinaryTreeNode {
    public int nodeValue;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public void setChildNode(BinaryTreeNode left, BinaryTreeNode right){
        this.left = left;
        this.right = right;
    }
}
