package com.coding_interiews.demo34;

/**
 * @author WJ
 * @date 2018/07/25
 */
public class BinaryTreeNode {
    public  Integer nodeValue;
    public  BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(Integer nodeValue) {
        this.nodeValue = nodeValue;
    }

    public void setChildNode(BinaryTreeNode left, BinaryTreeNode right){
        this.left = left;
        this.right = right;
    }
}
