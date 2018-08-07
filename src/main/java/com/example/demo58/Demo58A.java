package com.example.demo58;

/**
 * @author WJ
 * @date 2018/08/07
 * 面试题58A:翻转字符串
 *
 * 题目
 *  输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 *  例如输入字符串为“I am a Student.",则输出为”Student. a am i".
 *
 * 思路:
 *  1.首先把整个句子进行翻转
 *  2.把句子里面的单词依次翻转
 */
public class Demo58A {

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

    /**
     * 翻转句子
     * @param sentence 翻转句子
     * @return         返回翻转后的句子
     */
    private static char[] reverseSentence(char[] sentence) {
        if (sentence == null || sentence.length == 0) {
            return null;
        }
        int begin = 0;
        int end = 0;

        //翻转整个句子
        reverse(sentence, 0, sentence.length - 1);
        while (begin < sentence.length - 1) {
            if (sentence[begin] == ' ') {
                begin++;
                end++;
            } else if (sentence[end] == ' ' || end == sentence.length - 1) {
                reverse(sentence, begin, end - 1);
                begin = ++end;
            } else {
                end++;
            }
        }
        return sentence;
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        char[] array = str.toCharArray();
        System.out.println(reverseSentence(array));

        String str1 = "I  am    a     student.";
        char[] array1 = str1.toCharArray();
        System.out.println(reverseSentence(array1));
    }
}
