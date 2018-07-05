package com.example.demo7;

import java.util.Stack;

/**
 * @author WJ
 * @date 2018/07/05
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
//        System.out.println(stringMQueue.deleteHead());
    }


}
