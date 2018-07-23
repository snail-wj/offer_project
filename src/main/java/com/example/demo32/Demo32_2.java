package com.example.demo32;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WJ
 * @date 2018/07/24
 * 面试题32-2:把二叉树打印成多行
 *
 * 题目:
 *  从上到下按层打印二叉树，同一层的结点按从左到右顺序打印，每一层打印到一行。
 *
 * 参考:
 *  https://blog.csdn.net/liyazhou0215/article/details/72934033
 *
 * 思路:
 * 1.队列
 * 2.两个辅助变量，一个变量保存当前层还没有打印的结点数，
 *   另一个变量保存下一层结点的数目
 */
public class Demo32_2 {

    public static void printBinTree(BinaryTreeNode root){
        if(root == null){
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nexLevel = 0;
        int thisLevel = 1;
        while (!queue.isEmpty()){
            BinaryTreeNode currentNode = queue.poll();
            if(currentNode.left != null){
                queue.offer(currentNode.left);
                nexLevel ++;
            }
            if(currentNode.right != null){
                queue.offer(currentNode.right);
                nexLevel ++;
            }
            thisLevel --;
            System.out.print(currentNode.nodeValue + "\t");
            if(thisLevel == 0){
                System.out.println();
                thisLevel = nexLevel;
                nexLevel = 0;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(8);
        BinaryTreeNode root2 = new BinaryTreeNode(6);
        BinaryTreeNode root3 = new BinaryTreeNode(10);
        BinaryTreeNode root4 = new BinaryTreeNode(5);
        BinaryTreeNode root5 = new BinaryTreeNode(7);
        BinaryTreeNode root6 = new BinaryTreeNode(9);
        BinaryTreeNode root7 = new BinaryTreeNode(11);

        root1.setChildNode(root2,root3);
        root2.setChildNode(root4,root5);
        root3.setChildNode(root6,root7);

        printBinTree(root1);
    }
}
