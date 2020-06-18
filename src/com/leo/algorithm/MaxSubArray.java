package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {

    //动态规划法
    public int maxSubArray(int[] nums) {
        //记录每一步的值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i] + nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
