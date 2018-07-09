package com.example.demo14;

/**
 * @author WJ
 * @date 2018/07/10
 * 面试题14：剪绳子
 *
 * 题目:
 * 给你一根长度为n的绳子，请把绳子剪成m段(m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],...,k[m].
 * 请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 */
public class Demo14 {

    /**
     * 动态规划
     * @param length 绳子的长度
     * @return
     */
    private int maxAfterCutting_Solution1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        //子问题的最优解存储在products数组中，数组中的第i个元素标示为i的绳子
        //剪成若干段后各段长度乘积的最大值
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        /**
         * 我们注意到代码中的第一个for循环变量i是顺序递增的，这意味着
         * 计算顺序是自下而上的。因此在求f(i)之前，对于每一个j(0<i<j)而言，
         * f(j)都已经求解出来了，并且结果保存在projects[j]里， 为了求解f(i),
         * 我们需要求出所有可能的f(i)*f(i-j)并且比较得出他们的最大值，这是
         * 我们代码中第二个for循环的功能+
         */
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int num = products[j] * products[i - j];
                if (max < num) {
                    max = num;
                }
                products[i] = max;
            }
        }
        return products[length];
    }

    /**
     * 贪婪算法
     * @param length
     * @return
     */
    private int maxAfterCutting_Solution2(int length){
        if(length < 2){
            return 0;
        }
        if(length == 2){
            return 1;
        }
        if(length == 3){
            return 2;
        }

        // 尽可能多地剪去长度为3的绳子段
        int timesOf3 = length /3;

        //当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段。
        //此时更好的方法就是把绳子剪成长度为2的两段，因为2*2 》 1*3
        if(length - timesOf3 *3 == 1){
            timesOf3 -= 1;
        }

        int timesOf2 = (length - timesOf3 * 3 ) / 2;

        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    public static void main(String[] args) {
        Demo14 demo14 = new Demo14();
        System.out.println("绳子长度为5：" + demo14.maxAfterCutting_Solution1(5) + "[6]");
        System.out.println("绳子长度为5：" + demo14.maxAfterCutting_Solution2(5) + "[6]");
    }
}
