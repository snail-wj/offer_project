package com.offer;

import java.math.BigInteger;

/**
 * @author WJ
 * @date 2018/08/30
 * 大数求和
 */
public class BigNumber {

    public static void main(String[] args) {
        BigInteger first = new BigInteger("1111111111111111111111111111111111111119");
        BigInteger second = new BigInteger("1111111111111111111111111111111111111116");
        BigInteger sum = first.add(second);
        System.out.println(sum.toString());
    }
}
