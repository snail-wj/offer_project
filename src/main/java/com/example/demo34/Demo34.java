package com.example.demo34;

import java.util.ArrayList;

/**
 * @author WJ
 * @date 2018/07/25
 * 面试题34:二叉树中和为某一值的路径
 *
 * 题目:
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 参考url:
 * https://blog.csdn.net/dawn_after_dark/article/details/80964376
 */
public class Demo34 {

    public static ArrayList<ArrayList<Integer>> findPath(BinaryTreeNode root, int target){
        if(root == null){
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        findPath(result, temp,0, root, target);
        return result;
    }

    /**
     * 利用二叉树的前序遍历的知识来做
     * @param result    最后的结果
     * @param temp      当前的路径
     * @param sum       当前的和
     * @param root      路径中的最后一个节点
     * @param target    目标值
     */
    public static void findPath(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp,int sum, BinaryTreeNode root, int target ){
        temp.add(root.nodeValue);
        sum += root.nodeValue;
        if(root.left == null && root.right == null && sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }

        //遍历该点的左子树
        if(root.left != null){
            findPath(result, temp, sum, root.left, target);
            temp.remove(temp.size() -1);
        }

        //遍历该点的右子数
        if(root.right != null){
            findPath(result, temp, sum, root.right, target);
            temp.remove(temp.size() -1);
        }

    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(10);
        BinaryTreeNode root2 = new BinaryTreeNode(5);
        BinaryTreeNode root3 = new BinaryTreeNode(12);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root5 = new BinaryTreeNode(7);

        root1.setChildNode(root2, root3);
        root2.setChildNode(root4,root5);
        ArrayList<ArrayList<Integer>> path = findPath(root1, 22);
        System.out.println(path);
    }
}
