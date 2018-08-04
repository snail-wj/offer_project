package com.example.demo54;

/**
 * @author WJ
 * @date 2018/08/04
 */
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public void setChild(BinaryTreeNode left, BinaryTreeNode right){
        this.left = left;
        this.right = right;
    }
}
