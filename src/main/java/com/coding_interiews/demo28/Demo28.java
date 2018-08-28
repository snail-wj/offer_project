package com.coding_interiews.demo28;

/**
 * @author WJ
 * @date 2018/07/21
 * 面试题28:对称的二叉树
 *
 * 题目:
 * 请实现一个函数来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Demo28 {

    /**
     * 验证一颗二叉树是否为对称的二叉树第一种方法
     *
     * @param root
     * @return
     */
    public static Boolean isSymmetrical1(BinaryTreeNode root) {
        return travelsalTreeNode1(root).equals(travelsalTreeNode2(root));
    }

    /**
     * 前序遍历:根节点->左节点->右节点
     *
     * @param root
     * @return
     */
    public static String travelsalTreeNode1(BinaryTreeNode root) {
        String s = "";
        if (root == null) {
            return "null";
        }
        s += root.value + ",";
        s += travelsalTreeNode1(root.left);
        s += travelsalTreeNode1(root.right);
        return s;
    }

    /**
     * 前序遍历另一种引申:根节点->右节点->左节点
     *
     * @param root
     * @return
     */
    public static String travelsalTreeNode2(BinaryTreeNode root) {
        String s = "";
        if (root == null) {
            return "null";
        }
        s += root.value + ",";
        s += travelsalTreeNode2(root.right);
        s += travelsalTreeNode2(root.left);
        return s;
    }

    /**
     * 验证一颗二叉树是否为对称的二叉树的第二种方法
     *
     * @param root
     * @return
     */
    public static Boolean isSymmetrical2(BinaryTreeNode root) {
        return isSymmetrical(root, root);
    }

    public static Boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = construction1();
        BinaryTreeNode root2 = construction2();
        BinaryTreeNode root3 = construction3();

        System.out.println(isSymmetrical1(root1));
        System.out.println(isSymmetrical2(root1));
        System.out.println(isSymmetrical1(root2));
        System.out.println(isSymmetrical2(root2));
        System.out.println(isSymmetrical1(root3));
        System.out.println(isSymmetrical2(root3));
    }

    public static BinaryTreeNode construction1(){
        BinaryTreeNode root1 = new BinaryTreeNode(8);
        BinaryTreeNode root2 = new BinaryTreeNode(6);
        BinaryTreeNode root3 = new BinaryTreeNode(6);
        BinaryTreeNode root4 = new BinaryTreeNode(5);
        BinaryTreeNode root5 = new BinaryTreeNode(7);
        BinaryTreeNode root6 = new BinaryTreeNode(7);
        BinaryTreeNode root7 = new BinaryTreeNode(5);

        root1.setChildNode(root2, root3);
        root2.setChildNode(root4,root5);
        root3.setChildNode(root6,root7);

        return root1;
    }

    public static BinaryTreeNode construction2(){
        BinaryTreeNode root1 = new BinaryTreeNode(8);
        BinaryTreeNode root2 = new BinaryTreeNode(6);
        BinaryTreeNode root3 = new BinaryTreeNode(9);
        BinaryTreeNode root4 = new BinaryTreeNode(5);
        BinaryTreeNode root5 = new BinaryTreeNode(7);
        BinaryTreeNode root6 = new BinaryTreeNode(7);
        BinaryTreeNode root7 = new BinaryTreeNode(5);

        root1.setChildNode(root2, root3);
        root2.setChildNode(root4,root5);
        root3.setChildNode(root6,root7);
        return root1;
    }

    public static BinaryTreeNode construction3(){
        BinaryTreeNode root1 = new BinaryTreeNode(7);
        BinaryTreeNode root2 = new BinaryTreeNode(7);
        BinaryTreeNode root3 = new BinaryTreeNode(7);
        BinaryTreeNode root4 = new BinaryTreeNode(7);
        BinaryTreeNode root5 = new BinaryTreeNode(7);
        BinaryTreeNode root6 = new BinaryTreeNode(7);
        BinaryTreeNode root7 = null;

        root1.setChildNode(root2, root3);
        root2.setChildNode(root4,root5);
        root3.setChildNode(root6,root7);
        return root1;
    }
}
