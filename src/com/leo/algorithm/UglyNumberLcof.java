package com.leo.algorithm;

public class UglyNumberLcof {

    public static void main(String[] args) {
        int n = 103;
        int result = nthUglyNumberOffice(n);
        System.out.println(result);
    }

    //遇题不绝 暴力求解！解题速度慢 说明你机器性能差！

    public static int nthUglyNumber(int n) {
        int count = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (isUgly(i)) {
                count++;
                if (count == n) {
                    return i;
                }
            }
        }
        return 0;
    }

    private static boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
            if (num % 2 == 0) {
                return isUgly(num / 2);
            }
            if (num % 3 == 0) {
                return isUgly(num / 3);
            }
            if (num % 5 == 0) {
                return isUgly(num / 5);
            }
        }
        return false;
    }

    //=================官方求解=====================

    /**
     * 动态规划
     * “丑数 == 某较小丑数 \times× 某因子
     * @param n
     * @return
     */
    public static int nthUglyNumberOffice(int n) {
        int a = 0;
        int b = 0;
        int c = 0;

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int num1 = dp[a] * 2;
            int num2 = dp[b] * 3;
            int num3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(num1, num2), num3);
            if (dp[i] == num1) {
                a++;
            }

            if (dp[i] == num2) {
                b++;
            }

            if (dp[i] == num3) {
                c++;
            }
        }
        return dp[n - 1];
    }


}
