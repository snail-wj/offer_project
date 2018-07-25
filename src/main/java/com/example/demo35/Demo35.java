package com.example.demo35;

import java.util.StringTokenizer;

/**
 * @author WJ
 * @date 2018/07/25
 *
 * 面试题35：复杂链表的复制
 *
 * 题目:
 * 请实现函数 ComplexListNode clone(ComplexListNode head)，
 * 复制一个复杂链表。在复杂链表中，每个结点除了有一个指向下一个结点的指针外，
 */
public class Demo35 {

    /**
     * 第一步
     * 复制原始链表的任意节点N并创建新节点N'，再把N'链接到N的后面
     * @param pHead
     */
    public static void cloneNode(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        while (pNode != null) {
            ComplexListNode pCloned = new ComplexListNode(pNode.nodeValue);
            pCloned.nextNode = pNode.nextNode;
            pCloned.siblingNode = null;

            pNode.nextNode = pCloned;
            pNode = pCloned.nextNode;
        }
    }

    /**
     * 第二步
     * 如果原始链表上的节点N的siblingNode指向S，则他对应的复制节点N'的siblingNode指向S的复制节点S'
     * @param pHead
     */
    public static void connectSiblingNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        while (pNode != null) {
            ComplexListNode pCloned = pNode.nextNode;
            if (pNode.siblingNode != null) {
                pCloned.siblingNode = pNode.siblingNode.nextNode;
            }
            pNode = pCloned.nextNode;
        }
    }

    /**
     * 第三步
     * 把第二步得到的链表拆分为两个链表，奇数位置上的节点组成原始链表，偶数位置上的节点组成复制出来的链表
     * @param pHead
     * @return
     */
    public static ComplexListNode reConnectNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        ComplexListNode pClonedNode = null;
        ComplexListNode pClonedHead = null;

        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.nextNode;
            pNode.nextNode = pClonedNode.nextNode;
            pNode = pNode.nextNode;
        }

        while (pNode != null) {
            pClonedNode.nextNode = pNode.nextNode;
            pClonedNode = pClonedNode.nextNode;
            pNode.nextNode = pClonedNode.nextNode;
            pNode = pNode.nextNode;
        }

        return pClonedHead;
    }

    public static String printComplexListNode(ComplexListNode node) {
        String s = "";
        if (node == null) {
            return "";
        }
        s += "---n--->"+ node.nodeValue +"---s--->" +  (node.siblingNode != null ? node.siblingNode.nodeValue:"null") + "\n" ;
        s += printComplexListNode(node.nextNode);
        return s;
    }

    public static void main(String[] args) {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);

        node1.setOtherNode(node2, node3);
        node2.setOtherNode(node3, node5);
        node3.setOtherNode(node4);
        node4.setOtherNode(node5, node2);

        cloneNode(node1);
        connectSiblingNodes(node1);
        ComplexListNode node1Cloned = reConnectNodes(node1);
        System.out.println(node1 == node1Cloned);

        System.out.println(printComplexListNode(node1Cloned));
    }
}
