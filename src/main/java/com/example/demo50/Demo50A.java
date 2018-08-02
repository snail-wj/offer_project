package com.example.demo50;

/**
 * @author WJ
 * @date 2018/08/02
 * 面试题50:第一个只出现一次的字符串
 *
 * 题目:
 *  在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。如果字符串为空,返回-1
 *
 *
 * 提示:
 *  1.字符char的范围是-128到127，不仅仅是a-z,之所以int的数组的长度规定为256，是为了加上一个128不至于越界
 *
 * 参考url:
 *  https://blog.csdn.net/zjkc050818/article/details/71453529
 */
public class Demo50A {
    private static int firstNotRepeatingChar(String str){
        if(str == null || ("").equals(str)){
            return -1;
        }
        char[] chars = str.toCharArray();
        int[] arr = new int[256];
        for (char c:chars) {
            arr[hash(c)] ++;
        }

        int index = 0;
        for(int i = 0;i < chars.length; i++){
            if(arr[hash(chars[i])] == 1){
                index = i;
                break;
            }
        }
        return index;
    }


    /**
     * 为字符建立哈希映射，映射数组的下标
     * @param c
     * @return
     */
    private static int hash(char c){
        return c + 128;
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("abcdebad"));
        System.out.println(firstNotRepeatingChar("aaabbbccc"));
    }
}
