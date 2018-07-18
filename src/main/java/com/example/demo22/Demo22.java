package com.example.demo22;

/**
 * @author WJ
 * @date 2018/07/19
 * 面试题22:链表中倒数第k个节点
 *
 * 题目:
 *  输入一个链表，输出该链表中倒数第k 个结点．为了符合大多数人的习惯，
 *  本题从 1 开始计数，即链表的尾结点是倒数第 1 个结点．例如一个链表有 6 个结点，
 *  从头结点开始它们的值依次是 1 、2、3、4、5 、6。这个个链表的倒数第 3 个结点是值为 4 的结点。
 *
 *
 * 解题思路:
 * 为了实现只遍历链表一次就能找到倒数第 k 个结点，我们可以定义两 个指针。第一个指针从链表的头指针开始遍历向前走 k-1步，
 * 第二个指针保持不动；从第k 步开始，第二个指针也开始从链表的头指针开始遍历。由于两个指针的距离保持在 k-1 ，
 * 当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第 k 个结点。
 */
public class Demo22 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            if(fast.nextNode == null){
                return null;
            }
            fast = fast.nextNode;
        }
        while (fast.nextNode != null){
            fast = fast.nextNode;
            slow = slow.nextNode;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.nextNode = listNode2;
        listNode2.nextNode = listNode3;
        listNode3.nextNode = listNode4;
        listNode4.nextNode = listNode5;
        listNode5.nextNode = listNode6;

        Demo22 demo22 = new Demo22();
        ListNode listNode = demo22.FindKthToTail(listNode1, 4);
        System.out.println(listNode);

    }
}
