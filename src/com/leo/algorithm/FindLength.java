package com.leo.algorithm;

public class FindLength {

    public static void main(String[] args) {
        int[] A = {0, 0, 0, 0, 1};
        int[] B = {1, 0, 0, 0, 0};

        FindLength f = new FindLength();
        int res = f.findLength(A, B);
        System.out.println(res);
    }

    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[0]) {
                dp[0][i] = 1;
            }
        }

        for (int i = 0; i < B.length; i++) {
            if (B[i] == A[0]) {
                dp[i][0] = 1;
            }
        }
        int res = dp[0][0];
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < B.length + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public int findLength2(int[] A, int[] B) {

        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < B.length + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
