package com.coding_interiews.demo48;

/**
 * @author WJ
 * @date 2018/07/31
 * 面试题48:最长不含重复字符的子字符串
 *
 * 题目:
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从’a’到’z’的字符。例如，在字符串中”arabcacfr”，
 * 最长非重复子字符串为”acfr”，长度为4。
 *
 * 参考url:
 * https://blog.csdn.net/m0_37862405/article/details/80369128
 *
 */
public class Demo48 {

    private static int findLongestSubstringLength(String str){
        if(str == null || "".equals(str)){
            return 0;
        }
        int maxLength = 0;
        int curLength = 0;
        int[] positions = new int[26];
        for(int i = 0; i < positions.length; i++){
            positions[i] = -1;
        }
        for(int i = 0; i < str.length(); i++){
            int curChar = str.charAt(i) - 'a';
            int prePosition = positions[curChar];
            // 当前字符与它上次出现的位置之间的距离
            int distance = i - prePosition;
            // 当前字符第一次出现，或者前一个非重复子字符串中没有包含当前字符
            if(prePosition < 0 || distance > curLength){
                curLength ++;
            }else {
                //更新最长非重复子字符串的长度
                if(curLength > maxLength){
                    maxLength = curLength;
                }
                curLength = distance;
            }
            //更新字符出现的位置
            positions[curChar] = i;
        }
        if(curLength > maxLength){
            maxLength = curLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubstringLength("arabcacfr"));
        System.out.println(findLongestSubstringLength("bbbb"));
        System.out.println(findLongestSubstringLength("abcbdea"));
        System.out.println(findLongestSubstringLength(""));
    }

}
