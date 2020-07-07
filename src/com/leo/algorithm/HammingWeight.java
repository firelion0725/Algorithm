package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class HammingWeight {

    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            count++;
            //这里关键的想法是对于任意数字 nn ，将 nn 和 n - 1n−1 做与运算，会把最后一个 11 的位变成 0
            n = n & (n - 1);
        }
        return count;
    }
}
