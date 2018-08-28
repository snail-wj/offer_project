package com.coding_interiews.demo24;

/**
 * @author WJ
 * @date 2018/07/21
 * 面试题24:反转链表
 *
 * 题目:
 *  输入一个链表的头结点，反转该链表并输出反转后的头结点。
 */
public class Demo24 {

    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode preListNode = null;
        ListNode nowListNode = head;

        while (nowListNode != null){
            //保存下一个节点
            ListNode nextListNode = nowListNode.nextNode;
            //当前节点指向前一个节点
            nowListNode.nextNode = preListNode;
            //前任节点到现任节点
            preListNode = nowListNode;
            //现任节点到下一个节点
            nowListNode = nextListNode;
        }

        return preListNode;
    }

    public String printListNode(ListNode head){
        if(head == null){
            return null;
        }
        String s = "";
        while (head != null){
            s += head.nodeValue + "->";
            head = head.nextNode;
        }
        return s;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(5);

        head.nextNode = second;
        second.nextNode = third;
        third.nextNode = forth;

        Demo24 demo14 = new Demo24();
        System.out.println("reverse 之前的链表: "  + demo14.printListNode(head));
        ListNode listNode = demo14.reverseList(head);
        System.out.println(listNode);
        System.out.println("reverse 之后的链表: "  + demo14.printListNode(listNode));
    }
}
