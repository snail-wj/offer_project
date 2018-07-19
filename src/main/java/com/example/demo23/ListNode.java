package com.example.demo23;

/**
 * @author WJ
 * @date 2018/07/20
 */
public class ListNode {
    public int nodeValue;
    public ListNode nextNode;

    public ListNode(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public ListNode(int nodeValue, ListNode nextNode) {
        this.nodeValue = nodeValue;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "nodeValue=" + nodeValue +
                '}';
    }
}
