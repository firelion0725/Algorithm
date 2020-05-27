package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 */
public class SubArraySumsDivisibleByK {

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int reulst = subarraysDivByK(nums, k);
        System.out.println(reulst);
    }

    //暴力法求解
    public static int subarraysDivByK(int[] A, int K) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            for (int j = i; j < A.length; j++) {
                count += A[j];
                if (count % K == 0) {
                    result++;
                }
            }
        }
        return result;
    }



}
