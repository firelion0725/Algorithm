package com.leo.algorithm;

import java.lang.management.ManagementFactory;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Rob {

    public static void main(String[] args) {
        int[] nums = {1,2,1,1,9,1,1,10,3,1};
        Rob r = new Rob();
        r.rob(nums);
    }


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

}
