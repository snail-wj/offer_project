package com.example.demo17;

/**
 * @author WJ
 * @date 2018/07/15
 * 面试题17:打印从1到最大的n位数
 * 解法二:把问题换成数字排列的解法，递归简化代码
 */
public class Demo17_1 {

    private void printToMaxOfNDigits(int n){
        if(n < 0){
            return;
        }

        StringBuffer sb = new StringBuffer(n);
        for (int i = 0; i < n ; i++){
            sb.append("0");
        }
        for(int i = 0; i < 10; i++){
            sb.setCharAt(0, (char) (i + '0'));
            printToMaxOfNDigits_Recursely(sb, n, 0);
        }
    }

    private void printToMaxOfNDigits_Recursely(StringBuffer sb, int n, int index){
        if(index == n - 1){
            printNumber(sb);
            return;
        }
        for (int i = 0; i < 10; i++){
            sb.setCharAt(index + 1, (char) (i + '0'));
            printToMaxOfNDigits_Recursely(sb, n, index + 1);
        }
    }

    private void printNumber(StringBuffer sb){
        boolean isBegining = true;
        for (int i = 0; i < sb.length(); i++){
            if(isBegining && sb.charAt(i) != '0'){
                isBegining = false;
            }
            if(!isBegining){
                System.out.print(sb.charAt(i));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Demo17_1 demo171 = new Demo17_1();
        demo171.printToMaxOfNDigits(5);
    }
}
