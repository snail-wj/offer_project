package com.example.demo37;


/**
 * @author WJ
 * @date 2018/07/26
 * 面试题37:序列化二叉树
 *
 * 题目37:序列化和反序列化二叉树
 *
 * 参考目录:
 *  https://blog.csdn.net/liyazhou0215/article/details/73468736
 */
public class Demo37 {

    /**
     * 序列化二叉树
     * @param root  二叉树的根节点
     * @return      序列后的字符串
     */
    public static String serializeToString(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        String[] sequence = new String[]{""};
        serializeToString(root, sequence);
        return sequence[0];
    }

    public static void serializeToString(BinaryTreeNode root, String[] sequence) {
        if (root == null) {
            sequence[0] += ",#";
            return;
        }
        sequence[0] += ("," + root.nodeValue);
        serializeToString(root.left, sequence);
        serializeToString(root.right, sequence);
    }

    /**
     * 反序列化二叉树
     * @param sequence 序列化后的二叉树
     * @return 二叉树的根节点
     */
    public static BinaryTreeNode deserializeToBinTree(String sequence) {
        if (sequence == null || sequence.length() == 0) {
            return null;
        }
        String[] values = sequence.split(",");
        return deserializeToBinTree(values, new int[]{0});

    }

    public static BinaryTreeNode deserializeToBinTree(String[] values, int[] index) {
        String value = values[++index[0]];
        BinaryTreeNode root = null;
        if (value.matches("[0-9]+")) {
            root = new BinaryTreeNode(1);
            root.nodeValue = Integer.valueOf(value);

            root.left = deserializeToBinTree(values, index);
            root.right = deserializeToBinTree(values, index);
        }
        return root;
    }

    public static String printBinaryTree(BinaryTreeNode node) {
        String s = "";
        if (node == null) {
            return "";
        }
        s += node.nodeValue + "->";
        s += printBinaryTree(node.left);
        s += printBinaryTree(node.right);
        return s;
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode root3 = new BinaryTreeNode(3);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root5 = new BinaryTreeNode(5);
        BinaryTreeNode root6 = new BinaryTreeNode(6);

        root1.setChild(root2, root3);
        root2.setChild(root4, null);
        root3.setChild(root5, root6);

        String serializeToString = serializeToString(root1);
        System.out.println(serializeToString);

        BinaryTreeNode binaryTreeNode = deserializeToBinTree(serializeToString);
        System.out.println(printBinaryTree(binaryTreeNode));
    }
}
