package com.coding_interiews.demo32;

import java.util.Stack;

/**
 * @author WJ
 * @date 2018/07/24
 * 面试题32_3:按之字形顺序打印二叉树
 * <p>
 * 题目:
 * 请实现一个函数按照之字型顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 参考url:
 * https://blog.csdn.net/liyazhou0215/article/details/73457958
 * <p>
 * 思路:
 * 1. 使用两个栈协同工作
 * 2. 当遍历到奇数层时，先保存其右孩子到栈中，再保存其左孩子
 * 当遍历到偶数层时，先保存其左孩子到栈中，再保存其右孩子
 * （打印后的元素立刻出栈，则刚进入到一个新的层时，其中的一个栈是空的，将新层中的元素的孩子保存到这个空栈中）
 * <p>
 * 考察点:
 * 层次遍历（广度优先遍历）不使用递归
 * 栈的应用
 */
public class Demo32_3 {

    public static void snakePrint(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        //保存奇数层的元素
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        //保存偶数层的元素
        Stack<BinaryTreeNode> stack2 = new Stack<>();

        //1 表示奇数层，0 表示偶数层
        int current = 1;
        stack1.push(root);

        Stack<BinaryTreeNode> currentStack;
        Stack<BinaryTreeNode> nextStack;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            // 选取奇数层或者偶数层为当前层，以访问该层的元素
            currentStack = current == 1 ? stack1 : stack2;
            // 选取奇数层或者偶数层为下一层，以存放当前层元素的孩子
            nextStack = current == 1 ? stack2 : stack1;

            // 访问当前层的元素，栈顶元素
            BinaryTreeNode node = currentStack.pop();
            System.out.print(node.nodeValue + "\t");

            // 若当前层是奇数层，则先保存左孩子，再保存右孩子
            if (current == 1) {
                if (node.left != null) {
                    nextStack.push(node.left);
                }
                if (node.right != null) {
                    nextStack.push(node.right);
                }
            } else {    // 若当前层是偶数层，则先保存右孩子，再保存左孩子
                if (node.right != null) {
                    nextStack.push(node.right);
                }
                if (node.left != null) {
                    nextStack.push(node.left);
                }
            }
            // 当前层的元素被打印完毕，则换行，
            // 并将当前行设置为下一行，也即是若当前行是奇数层，则设置为偶层数，反之，设置为奇数层。
            if (currentStack.isEmpty()) {
                System.out.println();
                current = current == 0 ? 1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode root3 = new BinaryTreeNode(3);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root5 = new BinaryTreeNode(5);
        BinaryTreeNode root6 = new BinaryTreeNode(6);
        BinaryTreeNode root7 = new BinaryTreeNode(7);
        BinaryTreeNode root8 = new BinaryTreeNode(8);
        BinaryTreeNode root9 = new BinaryTreeNode(9);
        BinaryTreeNode root10 = new BinaryTreeNode(10);
        BinaryTreeNode root11 = new BinaryTreeNode(11);
        BinaryTreeNode root12 = new BinaryTreeNode(12);
        BinaryTreeNode root13 = new BinaryTreeNode(13);
        BinaryTreeNode root14 = new BinaryTreeNode(14);
        BinaryTreeNode root15 = new BinaryTreeNode(15);

        root1.setChildNode(root2, root3);
        root2.setChildNode(root4, root5);
        root3.setChildNode(root6, root7);
        root4.setChildNode(root8, root9);
        root5.setChildNode(root10, root11);
        root6.setChildNode(root12, root13);
        root7.setChildNode(root14, root15);

        snakePrint(root1);
    }
}
