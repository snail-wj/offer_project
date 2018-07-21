package com.example.demo24;

/**
 * @author WJ
 * @date 2018/07/21
 */
public class ListNode {
    public int nodeValue;
    public ListNode nextNode;

    public ListNode(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "nodeValue=" + nodeValue +
                '}';
    }
}
