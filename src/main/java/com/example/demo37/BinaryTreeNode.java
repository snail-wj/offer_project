package com.example.demo37;

/**
 * @author WJ
 * @date 2018/07/26
 */
public class BinaryTreeNode {
    public int nodeValue;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public void setChild(BinaryTreeNode left, BinaryTreeNode right){
        this.left = left;
        this.right = right;
    }
}
