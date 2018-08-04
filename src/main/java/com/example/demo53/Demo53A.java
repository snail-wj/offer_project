package com.example.demo53;

/**
 * @author WJ
 * @date 2018/08/04
 * 面试题53:在排序数组中查找数字
 *
 * 题目:
 *  统计一个数字在排序数组中出现的次数。
 *  输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 */
public class Demo53A {
    /**
     * 得到第一个k所在的位置
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getFirstK(int[] data, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = data[middleIndex];
        if (middleData == k) {
            if ((middleIndex > 0 && data[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstK(data, k, start, end);
    }

    /**
     * 得到最后一个k所在的位置
     * @param data
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getLastK(int[] data, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = data[middleIndex];
        if (middleData == k) {
            if ((middleIndex < data.length - 1 && data[middleIndex + 1] != k) || middleIndex == data.length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }
        return getLastK(data, k, start, end);
    }

    private static int getNumberOk(int[] data, int k) {
        int number = 0;
        if (data != null && data.length > 0) {
            int first = getFirstK(data, k, 0, data.length - 1);
            int last = getLastK(data, k, 0, data.length - 1);
            if(first > -1 && last > -1){
                number = last - first + 1;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,3,3,3,4,5};
        int[] array2 = {1,2,3,3,3};
        int[] array3 = {};
        System.out.println(getNumberOk(array1, 3));
        System.out.println(getNumberOk(array1, 3));
        System.out.println(getNumberOk(array3, 3));
        System.out.println(getNumberOk(array1, 6));
    }
}
