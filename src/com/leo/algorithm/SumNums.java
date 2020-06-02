package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class SumNums {

    public static void main(String[] args) {
        int n = 2;
        int result = sumNums(n);
        System.out.println(result);
    }

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
     * <p>
     * 基本就剩递归了。。。。
     */
    public static int sumNums(int n) {
        return helper(0, 1, n);
    }

    private static int helper(int sum, int start, int end) {
        if (start == end) {
            return sum + start;
        }

        if (start > end) {
            return sum;
        }
        sum += (start + end);
        sum = helper(sum, start + 1, end - 1);
        return sum;
    }
}
