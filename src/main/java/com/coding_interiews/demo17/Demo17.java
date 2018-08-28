package com.coding_interiews.demo17;


/**
 * @author WJ
 * @date 2018/07/12
 * 面试题17:打印1到最大的n位数
 *
 * 题目:
 * 输入数字n，按顺序打印出1到最大的n位十进制数。比如输入3，
 * 则打印出1、2、3一直到最大的3位数即999。
 *
 * 参考文章:https://blog.csdn.net/yingzizizizizizzz/article/details/71714100
 */
public class Demo17 {

    private void printNum(int n) {
        if (n <= 0)
            return;
        StringBuffer sb = new StringBuffer("");
        while (n -- > 0) {
            sb.append("0");
        }
        while (!increment(sb)){
            printNum(sb);
        }

    }

    private boolean increment(StringBuffer s){
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = s.length();
        for (int i = nLength - 1; i >= 0; i--){
            int nSum = s.charAt(i) - '0' + nTakeOver;
            if(i == nLength - 1){
                nSum ++; //低位+1
            }
            if(nSum >= 10){
                if(i == 0){ //在高位的时候nSum >= 10, 说明溢出了
                    isOverflow = true;
                }else {     //否则还没到，就进1
                    nSum -= 10;
                    nTakeOver = 1;
                    s.setCharAt(i, (char) ('0' + nSum));
                }
            }else {//每位不到10的时候，直接替换
                s.setCharAt(i, (char) ('0' + nSum));
                break;
            }
        }
        return isOverflow;
    }

    private void printNum(StringBuffer sb){
        boolean isBegin0 = true;
        int nLength = sb.length();
        for(int i = 0; i < nLength; i++){
            if(isBegin0 && sb.charAt(i) != '0'){
                isBegin0 = false;
            }
            if(!isBegin0){
                System.out.print(sb.charAt(i));
            }
        }
        System.out.println();
    }

    //TODO 还有第二种递归的方法

    public static void main(String[] args) {
        Demo17 demo17 = new Demo17();
        demo17.printNum(2);
    }
}
