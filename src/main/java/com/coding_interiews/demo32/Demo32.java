package com.coding_interiews.demo32;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WJ
 * @date 2018/07/23
 * 面试题32: 从上到下打印二叉树
 *
 * 题目:
 *  从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 *  例如输入下图的二叉树，则依次打印出 8、6、10、5、7、9、11.
 *
 *  参考url:
 *      https://blog.csdn.net/liyazhou0215/article/details/72791323
 *      https://blog.csdn.net/ustcjackylau/article/details/42454779
 */
public class Demo32 {

    public static void  levelVisitTree(BinaryTreeNode root){
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        //queue.offer(root) 近似于 queue.add(offer)
        for (queue.offer(root); ! queue.isEmpty();){
            //remove（）和poll都是从队列中删除第一个元素
            BinaryTreeNode currNode = queue.poll();
            System.out.print(currNode.nodeValue + ",");
            if(currNode.left != null){
                queue.offer(currNode.left);
            }
            if(currNode.right != null){
                queue.offer(currNode.right);
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

        levelVisitTree(root1);
    }
}
