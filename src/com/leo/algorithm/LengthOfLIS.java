package com.leo.algorithm;

public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            int d = nums[i];
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (d > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
