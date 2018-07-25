package com.example.demo35;

/**
 * @author WJ
 * @date 2018/07/25
 */
public class ComplexListNode {
    public int nodeValue;
    public ComplexListNode nextNode;
    public ComplexListNode siblingNode;

    public ComplexListNode(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public void setOtherNode(ComplexListNode nextNode, ComplexListNode siblingNode){
        this.nextNode = nextNode;
        this.siblingNode = siblingNode;
    }

    public void setOtherNode(ComplexListNode nextNode){
        this.nextNode = nextNode;
    }
}
