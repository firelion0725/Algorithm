package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "ezupkr";
        String text2 = "ubmrapg";
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        int res = l.longestCommonSubsequence(text1, text2);
        System.out.println(res);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for (int i = 1; i < text1.length()+1; i++) {
            for (int j = 1; j < text2.length()+1; j++) {
                if (c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

}
