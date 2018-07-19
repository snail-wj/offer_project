package com.example.demo23;

/**
 * @author WJ
 * @date 2018/07/20
 * 面试题23:链表中环的入口节点
 *
 * 题目:
 *  如果一个链表中包含环，如何找到出环的入口节点?
 */
public class Demo23 {

    /**
     * 在链表中存在环的前提下找到一快一慢两个指针相遇的节点
     * @param pHead
     * @return ListNode:节点中任意的一个节点 null:链表不存在
     */
    public ListNode meetingNode(ListNode pHead){
        if(pHead == null){
            return  null;
        }
        ListNode pSlow = pHead.nextNode;
        if(pSlow == null){
            return null;
        }
        ListNode pFast = pSlow.nextNode;
        while (pFast != null && pSlow != null){
            if(pFast == pSlow){
                return pFast;
            }
            pSlow = pSlow.nextNode;
            pFast = pFast.nextNode;
            if(pFast != null){
                pFast = pFast.nextNode;
            }
        }
        return null;
    }

    /**
     * 在找到换种任意一个节点之后，就能得出环中的节点数目，并找到环中的入口节点
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode pHead){
        ListNode meetingNode = meetingNode(pHead);
        if(meetingNode == null){
            return null;
        }

        //得到环中节点的数目
        int nodesInLoop = 1;
        ListNode pNode1 = meetingNode;
        while (pNode1.nextNode != meetingNode){
            pNode1 = pNode1.nextNode;
            ++ nodesInLoop;
        }

        //先移动PNode1,次数为环中节点数目
        pNode1 = pHead;
        for(int i = 0; i < nodesInLoop; i++){
            pNode1 = pNode1.nextNode;
        }

        //在移动pNode1和PNode2
        ListNode pNode2 = pHead;
        while (pNode1 != pNode2){
            pNode1 = pNode1.nextNode;
            pNode2 = pNode2.nextNode;
        }
        return pNode1;
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
        listNode6.nextNode = listNode4;

        Demo23 demo23 = new Demo23();
        ListNode listNode = demo23.entryNodeOfLoop(listNode2);
        System.out.println(listNode);
    }
}
