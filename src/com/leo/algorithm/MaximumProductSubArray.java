package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubArray {

    public static void main(String[] args) {
        int[] nums = {0, 2};
        maxProduct2(nums);
    }

    public static int maxProduct(int[] nums) {
        int sum = Integer.MIN_VALUE;
        //二重循环 暴力 找出最大 值 及 始末指针
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = i; j < nums.length; j++) {
                temp *= nums[j];
                if (temp > sum) {
                    sum = temp;
                }
            }
        }

        return sum;
    }

    // 动态规划
    public static int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imin;
                imin = imax;
                imax = temp;
            }

            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);

        }

        return max;
    }

}
