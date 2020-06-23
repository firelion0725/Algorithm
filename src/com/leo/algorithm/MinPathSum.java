package com.leo.algorithm;

import java.util.HashMap;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int path = 0;
        if (grid.length == 0) {
            return path;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        return helper(dp, grid.length - 1, grid[0].length - 1, grid, new HashMap<>());
    }

    private int helper(int[][] dp, int m, int n, int[][] grid, HashMap<String, Integer> map) {
        if (m == 0) {
            return dp[0][n];
        }

        if (n == 0) {
            return dp[m][0];
        }

        int d1;
        if (map.get(getKey(m - 1, n)) != null) {
            d1 = map.get(getKey(m - 1, n));
        } else {
            d1 = helper(dp, m - 1, n, grid, map);
            map.put(getKey(m, n), d1);
        }

        int d2;
        if (map.get(getKey(m, n - 1)) != null) {
            d2 = map.get(getKey(m, n - 1));
        } else {
            d2 = helper(dp, m, n - 1, grid, map);
            map.put(getKey(m, n - 1), d2);
        }

        int result = Math.min(d1, d2) + grid[m][n];
        map.put(getKey(m, n), result);

        return result;
    }

    private String getKey(int m, int n) {
        return m + "m" + n + "n";
    }

    public int minPathSumOffice(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row==0 || col==0) {
            return 0;
        }

        int dp[][] = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i=1; i<col; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i=1; i<row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = min + grid[i][j];
            }
        }

        return dp[row-1][col-1];
    }

}
