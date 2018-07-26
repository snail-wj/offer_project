package com.example.demo36;

/**
 * @author WJ
 * @date 2018/07/26
 * 面试题36:二叉搜索树和双向链表
 *
 * 题目:
 *  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *  要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *  比如输入下图中左边的二叉搜索树，则输出转换之后的排序双向链表。
 *
 *  参考url:
 *  https://blog.csdn.net/liyazhou0215/article/details/72801214
 *
 *  
 */
public class Demo36 {

    public static BinaryTreeNode convert(BinaryTreeNode root){
        BinaryTreeNode[] tailNode = new BinaryTreeNode[1];
        convert(root, tailNode);

        //tailNode指向双层链表的尾节点，将其移动到头节点的位置
        BinaryTreeNode head = tailNode[0];
        for(; head != null && head.left != null ; head = head.left);
        return head;
    }


    public static void convert(BinaryTreeNode currNode, BinaryTreeNode[] tailNode){
        if(currNode == null){
            return;
        }
        if(currNode.left != null){
            convert(currNode.left, tailNode);
        }

        currNode.left = tailNode[0];
        if(tailNode[0] != null){
            tailNode[0].right = currNode;
        }
        tailNode[0] = currNode;
        if(currNode.right != null){
            convert(currNode.right, tailNode);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(10);
        BinaryTreeNode root2 = new BinaryTreeNode(6);
        BinaryTreeNode root3 = new BinaryTreeNode(4);
        BinaryTreeNode root4 = new BinaryTreeNode(8);
        BinaryTreeNode root5 = new BinaryTreeNode(14);
        BinaryTreeNode root6 = new BinaryTreeNode(12);
        BinaryTreeNode root7 = new BinaryTreeNode(16);

        root1.setChild(root2, root5);
        root2.setChild(root3, root4);
        root5.setChild(root6, root7);

        BinaryTreeNode head = convert(root1);
        for (; head != null; head = head.right){
            System.out.print(head.value + "===");
        }
    }
}
