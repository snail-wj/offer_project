package com.coding_interiews.demo62;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WJ
 * @date 2018/08/11
 * 面试题62:圆圈中最后剩下的数字
 *
 * 题目:
 *  0, 1, 2, ..., n-1 这 n 个数字排成一个圆圈，从数字 0 开始每次从这个圆圈里删除第 m 个数字。
 *  求出这个圆圈里剩下的最后一个数字。
 *
 * 参考url:
 *  https://blog.csdn.net/liyazhou0215/article/details/72854623
 */
public class Demo62 {

    private static int lastRemainElement(int n, int m ){
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(i);
        }
        int idx = 0;
        for(int i= 0;i<n-1;i++){
            idx = idx + (m - 1);
            idx = idx % list.size();
            list.remove(idx);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastRemainElement(5,3));
        System.out.println(lastRemainElement(7,2));
    }
}
