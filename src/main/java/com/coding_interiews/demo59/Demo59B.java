package com.coding_interiews.demo59;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author WJ
 * @date 2018/08/08
 * 面试题59(第二题):队列的最大值
 *
 * 题目:
 *  定义一个队列并实现函数max得到队列里的最大值。要求max，pushBack，popFront的时间复杂度都是o(1)。
 *
 * 参考url:
 *  https://www.jianshu.com/p/13ab1c51eac6
 *
 */
public class Demo59B {

    private static Deque<Integer> queueData = new ArrayDeque<>();
    private static Deque<Integer> queueMax = new ArrayDeque<>();

    private static Integer max() {
        if (queueMax.isEmpty()) {
            return null;
        }
        return queueMax.peekFirst();
    }

    private static void pushBack(Integer value) {

        while (!queueMax.isEmpty() && value > queueMax.peekLast()) {
            queueMax.pollLast();
        }

        queueMax.offerLast(value);
        queueData.offerLast(value);
    }

    private static void popFront() throws Exception {
        if (queueData.isEmpty()) {
            throw new Exception("empty queue");
        }
        Integer value = queueData.pollFirst();
        if (queueMax.peekFirst() == value) {
            queueMax.pollFirst();
        }
    }

    public static void main(String[] args) throws Exception {
        pushBack(3);
        System.out.println(max());
        pushBack(5);
        System.out.println(max());
        pushBack(1);
        System.out.println(max());
        System.out.println("开始出队后，调用max");
        System.out.println(max());
        popFront();
        System.out.println(max());
        popFront();
        System.out.println(max());
        popFront();
        System.out.println(max());

    }
}
