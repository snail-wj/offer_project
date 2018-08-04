package com.example.demo52;

/**
 * @author WJ
 * @date 2018/08/04
 * 面试题52:两个链表的第一个公共节点
 *
 * 题目:
 *  输入两个链表，找出它们的第一个公共结点。
 *  1 --> 2 --> 3 \
 *                6 --> 7 --> 8
 *       4 --> 5 /
 *
 * 参考url:
 * https://blog.csdn.net/liyazhou0215/article/details/72821763
 */
public class Demo52 {

    private static ListNode findFirstComonNode(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        int len1 = lenOfList(node1);
        int len2 = lenOfList(node2);

        int diff = len1 - len2;
        ListNode commonNode = null;
        if (diff > 0) {
            node1 = moveN(node1, diff);
        } else {
            node2 = moveN(node2, -diff);
        }

        for (; node1 != null; node1 = node1.nextNode, node2 = node2.nextNode) {
            if (node1 == node2) {
                commonNode = node1;
                break;
            }
        }
        return commonNode;
    }

    private static ListNode moveN(ListNode head, int n) {
        for (; n > 0; n--) {
            head = head.nextNode;
        }
        return head;
    }

    private static int lenOfList(ListNode node) {
        int len = 0;
        for (; node != null; node = node.nextNode) {
            len++;
        }
        return len;
    }

    private static String printListNode(ListNode node) {
        String s = "";
        if (node == null) {
            return "";
        }
        s += node.nodeValue + "-->";
        s += printListNode(node.nextNode);
        return s;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);


        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);

        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node6);

        node4.setNextNode(node5);
        node5.setNextNode(node6);

        node6.setNextNode(node7);

        System.out.println(printListNode(findFirstComonNode(node1, node4)));
    }
}
