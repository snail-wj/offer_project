package com.example.demo9;

import java.util.Stack;

/**
 * @author WJ
 * @date 2018/07/05
 *
 * * 面试题7：用两个栈实现队列
 * 题目：
 *      用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，
 *      分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 *
 * 思路：
 *      1. 当在"队列"尾部插入结点时，把队列（子队列）的元素压入 A 栈
 *      2. 当删除"队列"的首部元素时，检查 B 栈是否为空，
 *              如果为空，将 A 栈中的元素弹出并依次压入B栈，此时 B 栈存储的就是子队列，可以访问该子队列的首部元素
 *              如果不为空，则 B 栈中已经存储子队列，可以访问子队列的首部元素
 *
 */
public class MQueue<T> {
    // 压入栈，存储添加的数据
    private Stack<T> pustStack = new Stack<>();
    //弹出栈，存储子队列
    private Stack<T> popStack = new Stack<>();

    public MQueue() {
    }

    public MQueue(T args[]) {
        for (T t : args) {
            pustStack.push(t);
        }
    }

    public void appendTail(T element){
        pustStack.push(element);
    }

    public T deleteHead(){
        //子队列为空的时候，再次创造队列
        if(popStack.isEmpty()){
            if(!pustStack.isEmpty()){
                T top = pustStack.pop();
                popStack.push(top);
            }
        }
        if(popStack.isEmpty()){
            throw new RuntimeException("queue is empty !");
        }
        return popStack.pop();
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        String[] newStr = {"a", "b", "c"};
        MQueue<String> stringMQueue = new MQueue<>(newStr);
        stringMQueue.appendTail("d");
        System.out.println(stringMQueue.deleteHead());
        System.out.println(stringMQueue.deleteHead());
    }


}
