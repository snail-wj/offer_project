package com.example.demo25;

import org.springframework.core.NestedExceptionUtils;

/**
 * @author WJ
 * @date 2018/07/21
 * 面试题25:合并两个排序的链表
 *
 * 题目:
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Demo25 {

    public ListNode merge(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        ListNode listNode = null;
        try {
            if (listNode1.nodeValue < listNode2.nodeValue) {
                listNode = listNode1;
                listNode.nextNode = merge(listNode1.nextNode, listNode2);
            } else {
                listNode = listNode2;
                listNode.nextNode = merge(listNode1, listNode2.nextNode);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return listNode;
    }

    public String printListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        String s = "";
        while (head != null) {
            s += head.nodeValue;
            if(head.nextNode != null){
                s+= "->";
            }
            head = head.nextNode;
        }
        return s;
    }

    public static void main(String[] args) {
        ListNode F1 = new ListNode(1);
        ListNode F2 = new ListNode(2);
        ListNode F3 = new ListNode(3);
        ListNode F4 = new ListNode(4);
        ListNode F5 = new ListNode(9);

        F1.nextNode = F2;
        F2.nextNode = F3;
        F3.nextNode = F4;
        F4.nextNode = F5;
        F5.nextNode = null;

        ListNode S1 = new ListNode(1);
        ListNode S2 = new ListNode(3);
        ListNode S3 = new ListNode(3);
        ListNode S4 = new ListNode(9);
        ListNode S5 = new ListNode(10);

        S1.nextNode = S2;
        S2.nextNode = S3;
        S3.nextNode = S4;
        S4.nextNode = S5;
        S5.nextNode = null;

        Demo25 demo25 = new Demo25();
        System.out.println("合并前的两个链表:");
        System.out.println("first:" + demo25.printListNode(F1));
        System.out.println("second:" + demo25.printListNode(S1));

        System.out.println("合并后的一个链表");
        System.out.println("after：" + demo25.printListNode(demo25.merge(F1, S1)));

        //如果写成了这样，会出现一个死循环，最后一位的堆地址，一直指向他自己本身
//        System.out.println("after：" + demo25.printListNode(demo25.merge(F1, S5)));
    }

}
