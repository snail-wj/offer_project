package com.example.demo30;

import java.util.Stack;

/**
 * @author WJ
 * @date 2018/07/21
 * 面试题30:包含min函数的栈
 *
 * 题目:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min，push及pop的时间复杂度都是O(1).
 */
public class Demo30 {
    private Stack<Integer> dataStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node){
        dataStack.push(node);
        if(minStack.isEmpty() || node < minStack.peek()){
            minStack.push(node);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public void pop(){
        dataStack.pop();
        minStack.pop();
    }

    public int min(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        Demo30 demo30 = new Demo30();
        demo30.push(3);
        demo30.push(4);
        demo30.push(2);
        demo30.push(1);
        System.out.println(demo30.min());
        demo30.pop();
        demo30.pop();
        System.out.println(demo30.min());
        demo30.push(0);
        demo30.push(9);
        System.out.println(demo30.min());
    }
}
