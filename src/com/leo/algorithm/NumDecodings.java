package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecodings {

    public static void main(String[] args) {
        NumDecodings n = new NumDecodings();
        n.numDecodings("1020");
    }

    public int numDecodings(String s) {

        char[] chars = s.toCharArray();
        //边界条件
        if (chars.length == 0) {
            return 0;
        }
        if (chars[0] == '0') {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        if (chars[0] > '2' && chars[1] == '0') {
            return 0;
        }
        //初始化dp表
        int[] dp = new int[chars.length];
        dp[0] = 1;
        if (chars[0] > '2' || chars[0] == '2' && chars[1] > '6' || chars[1] == '0') {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }

        //进入循环体 做状态转移
        for (int i = 2; i < chars.length; i++) {
            //考虑0的特殊情况
            if (chars[i] == '0' && (chars[i - 1] == '0' || chars[i - 1] > '2')) {
                return 0;
            } else if (chars[i] == '0' && chars[i - 1] <= '2') {
                dp[i] = dp[i-2];
            }else{
                int num = (chars[i - 1] - '0') * 10 + (chars[i] - '0');
                if (num >= 10 && num <= 26) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[chars.length - 1];
    }
}
