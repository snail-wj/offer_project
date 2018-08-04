package com.example.demo54;

/**
 * @author WJ
 * @date 2018/08/04
 * 面试题54：二叉搜索树的第k大节点
 *
 * 题目:
 *  给定一颗二叉搜索树，请找出其中的第k大的结点。
 *
 * 参考url:
 *  https://blog.csdn.net/u011080472/article/details/51290909
 */
public class Demo54 {

    private static int count = 0;
    private static BinaryTreeNode kthNode(BinaryTreeNode root, int k){
        if(root == null || k <= 0){
            return null;
        }
        BinaryTreeNode target = null;
        //遍历左子树
        if(root.left != null){
            target = kthNode(root.left, k);
        }
        //计数加一
        count ++;
        if(target == null){
            if(count == k){
                target = root;
                return target;
            }
        }

        //遍历右子树
        if(target == null && root.right != null){
            target = kthNode(root.right, k);
        }
        return target;
    }

    public static void main(String[] args) {
        BinaryTreeNode root5 = new BinaryTreeNode(5);
        BinaryTreeNode root3 = new BinaryTreeNode(3);
        BinaryTreeNode root7 = new BinaryTreeNode(7);
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root6 = new BinaryTreeNode(6);
        BinaryTreeNode root8 = new BinaryTreeNode(8);

        root5.setChild(root3, root7);
        root3.setChild(root2,root4);
        root7.setChild(root6,root8);

        BinaryTreeNode target = kthNode(root5, 5);
        System.out.println(target.value);
    }
}
