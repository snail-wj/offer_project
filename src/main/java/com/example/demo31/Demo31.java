package com.example.demo31;

import java.util.Stack;

/**
 * @author WJ
 * @date 2018/07/22
 */
public class Demo31 {

    /**
     *
     * @param push 入栈序列
     * @param pop  出栈序列
     * @return     true:出栈序列是入栈序列的一个弹出序列
     */
    public static boolean isPopOrder(int[] push, int[] pop) {

        // 用于记录判断出栈顺序是不是入栈顺的一个出栈序列，默认false
        boolean isPossible = false;

        // 当入栈和出栈数组者都不为空，并且都有数据，并且数据个数都相等
        if (push != null && pop != null && push.length > 0 && push.length == pop.length) {
            //用于存放入栈时的数据
            Stack<Integer> stack = new Stack<>();
            //记录下一个要处理的入栈元素的位置
            int nextPush = 0;
            //记录下一个要处理的出栈元素的位置
            int nextPop = 0;
            //如果出栈元素没有处理完就继续进行处理
            while (nextPop < pop.length) {
                //如果栈为空或者栈顶元素与当前处理的出栈元素不相同，一直进行操作
                while (stack.isEmpty() || stack.peek() != pop[nextPop]) {
                    //如果入栈元素已经全部入栈，就退出内层循环
                    if (nextPush >= push.length) {
                        break;
                    }
                    //执行到此处说明还有入栈元素可以入栈
                    //即将元素入栈
                    stack.push(push[nextPush]);
                    //指向下一个要处理的入栈元素的位置
                    nextPush++;
                }
                //执行到此处有两种情况:
                //第一种:在栈顶上找到了一个与出栈元素相等的元素
                //第二种:在栈顶上没有找到与一个与出栈元素相等的元素，而且输入栈已经全部入栈

                //对于第二种情况说明弹出栈的顺序是不符合要求的，退出外层循环
                if (stack.peek() != pop[nextPop]) {
                    break;
                }

                //对应到第一种情况:需要栈顶元素弹出
                stack.pop();
                //指向下一个要处理的出栈元素的位置
                nextPop++;
            }

            //对于第一种情况:stack.isEmpty（）一定必不为空
            //对于第二种情况:stack.isEmpty（）一定为空
            if (stack.isEmpty()) {
                isPossible = true;
            }
        }

        return isPossible;
    }

    public static void main(String[] args) {
        int push[] = {1,2,3,4,5};
        int pop1[] = {4,5,3,2,1};
        int pop2[] = {4,3,5,2,1};
        int pop3[] = {4,3,5,1,2};
        System.out.println(isPopOrder(push,pop1));
        System.out.println(isPopOrder(push,pop2));
        System.out.println(isPopOrder(push,pop3));
    }
}
