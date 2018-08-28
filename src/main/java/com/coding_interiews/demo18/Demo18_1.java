package com.coding_interiews.demo18;

/**
 * @author WJ
 * @date 2018/7/15
 *
 * 面试题18:删除链表中的节点(删除重复节点)
 * 题目:
 * 在一个排序的链表中，存在重复的结点（这个重复的节点指的是当前节点和下一节点相同），请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 *
 * 分析：
 *  1、新建一个头节点，以防止第一个节点被删除。
 *  2、保存当前节点的前一个节点，循环遍历整个链表，如果当前节点的值与下一个节点的值相等，则将当前节点的值与next.next节点的值比较，直到不相等或者null为止，最后将当前节点的前一个节点pre指向最后比较不相等的节点。
 *  3、如果当前节点与next节点不相等，则直接让节点指针全部向后移动一位。
 */
public class Demo18_1 {

    public ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }

        //前一个节点
        ListNode preNode = new ListNode();
        ListNode tmp = preNode;
        preNode.nextNode = head;
        //当前节点
        ListNode nowNode = head;

        while (nowNode != null) {
            //判断是否存在重复节点，是否应该删除
            if (nowNode.nextNode != null && nowNode.nodeValue == nowNode.nextNode.nodeValue) {
                while (nowNode.nextNode != null && nowNode.nodeValue == nowNode.nextNode.nodeValue) {
                    nowNode = nowNode.nextNode;
                }
                //删除相应的重复节点
                preNode.nextNode = nowNode.nextNode;
            } else {
                //preNode指针移动
                preNode = nowNode;
            }
            nowNode = nowNode.nextNode;
        }
        return tmp.nextNode;
    }

    /**
     * 打印链表
     *
     * @param head 链表的头结点
     */
    public void pringList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.nodeValue + "->");
            temp = temp.nextNode;
        }
    }

    public static void main(String[] args) {
        Demo18_1 demo18_1 = new Demo18_1();

        ListNode head = new ListNode();
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode temp3 = new ListNode();
        ListNode temp4 = new ListNode();
        ListNode temp5 = new ListNode();
        ListNode temp6 = new ListNode();

        head.nodeValue = 1;
        temp1.nodeValue = 2;
        temp2.nodeValue = 3;
        temp3.nodeValue = 3;
        temp4.nodeValue = 4;
        temp5.nodeValue = 4;
        temp6.nodeValue = 3;
        head.nextNode = temp1;
        temp1.nextNode = temp2;
        temp2.nextNode = temp3;
        temp3.nextNode = temp4;
        temp4.nextNode = temp5;
        temp5.nextNode = temp6;
        temp6.nextNode = null;

        System.out.println("删除前的链表:");
        demo18_1.pringList(head);


        System.out.println();
        System.out.println("-------------");

        //执行删除操作
        ListNode resultNode = demo18_1.deleteDuplication(head);
        System.out.println("删除后的链表:");
        demo18_1.pringList(resultNode);
    }
}
