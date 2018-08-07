package com.example.demo58;


/**
 * @author WJ
 * @date 2018/08/07
 * 面试题58B:左旋转字符串
 *
 * 题目:
 *  字符串的左悬殊操作是把字符串前面的若干个字符转移到字符串的尾部。
 *  请定义一个函数实现字符串左旋转操作的功能。
 *  比如输入字符串"abcdefg" 和数字 2，该函数将返回左旋转 2 位得到的结果"cdefgab"。
 *
 * 解题思路:
 *  1.把分开的字符串当做两部分，第一部分，要移动到后面的字符数组
 *  2.后面保持不变的字符数组，第二部分
 *  3.第一部分进行reverse,第二部分reverse,然后整体进行一个reverse
 */
public class Demo58B {

    /**
     * 翻转单词
     * @param array 字符数组
     * @param begin 开始翻转位置
     * @param end 结束翻转位置
     */
    private static void reverse(char[] array, int begin, int end) {
        if (array == null || array.length == 0) {
            return;
        }
        while (begin < end) {
            char tmp = array[begin];
            array[begin] = array[end];
            array[end] = tmp;
            begin++;
            end--;
        }
    }

    private static char[] reverSentence(char[] array, int n){
        if(array.length == n){
            return array;
        }
        if(array != null && array.length > 0 && array.length >= n && n >= 0){
            reverse(array, 0, n - 1);
            reverse(array, n, array.length - 1);
            reverse(array, 0, array.length - 1);
        }else {
            return "".toCharArray();
        }
        return array;
    }


    public static void main(String[] args) {
        String s = "abcdef";
        char[] array1 = s.toCharArray();
        char[] array2 = s.toCharArray();
        char[] array3 = s.toCharArray();
        System.out.println(reverSentence(array1, 2));
        System.out.println(reverSentence(array3, -1));
        System.out.println(reverSentence(array2, 3));
    }
}
