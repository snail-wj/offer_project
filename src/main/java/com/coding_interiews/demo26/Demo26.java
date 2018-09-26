package com.coding_interiews.demo26;

/**
 * @author WJ
 * @date 2018/07/21
 * 面试题26:树的子结构
 *
 * 题目:输入两棵二叉树A 和B，判断B 是不是A 的子结构。
 *
 */
public class Demo26 {

    /**
     * 输入两颗二叉树的A和B,判断数B是不是A的子结构
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {

        boolean result = false;
        if (root1 == root2 || root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            if (root1.value == root2.value) {
                result = DoesTree1HavaTree2(root1, root2);
            }
            if(!result){
                result = hasSubTree(root1.left, root2) || hasSubTree(root1.rigth, root2);
            }
        }

        return result;
    }

    public static boolean DoesTree1HavaTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if(root1.value != root2.value){
            return false;
        }

        return DoesTree1HavaTree2(root1.left, root2.left) && DoesTree1HavaTree2(root1.rigth, root2.rigth);
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(8);
        BinaryTreeNode root2 = new BinaryTreeNode(8);
        BinaryTreeNode root3 = new BinaryTreeNode(7);
        BinaryTreeNode root4 = new BinaryTreeNode(9);
        BinaryTreeNode root5 = new BinaryTreeNode(2);
        BinaryTreeNode root6 = new BinaryTreeNode(5);
        BinaryTreeNode root7 = new BinaryTreeNode(7);
        root1.left = root2;
        root1.rigth = root3;
        root2.left = root4;
        root2.rigth = root5;
        root5.left = root6;
        root5.rigth = root7;

        BinaryTreeNode matchRoot1 = new BinaryTreeNode(2);
        BinaryTreeNode matchRoot2 = new BinaryTreeNode(5);
        BinaryTreeNode matchRoot3 = new BinaryTreeNode(7);
        matchRoot1.left = matchRoot2;
        matchRoot1.rigth = matchRoot3;

        System.out.println(hasSubTree(root1,matchRoot1));
        System.out.println(hasSubTree(root1,root1));
        System.out.println(hasSubTree(root1,null));
        System.out.println(hasSubTree(null,null));
    }
}
