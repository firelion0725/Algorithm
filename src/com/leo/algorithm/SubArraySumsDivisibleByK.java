package com.leo.algorithm;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 */
public class SubArraySumsDivisibleByK {

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int reulst = subarraysDivByK2(nums, k);
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

    //前缀 hash求解
    public static int subarraysDivByK2(int[] A, int K) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int m = 0;
        for (int value : A) {
            sum += value;
            m = sum % K;
            if (m < 0) {
                m += K;
            }
            map.put(m, map.getOrDefault(m, 0) + 1);
            result += map.get(m) - 1;
        }
        return result;
    }


}
