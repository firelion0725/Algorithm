package com.leo.algorithm;

public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int y = obstacleGrid.length;
        int x = obstacleGrid[0].length;
        int[][] dp = new int[y][x];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i < x; i++) {
            dp[0][i] = (dp[0][i - 1] == 0 || obstacleGrid[0][i] == 1) ? 0 : 1;
        }

        for (int i = 1; i < y; i++) {
            dp[i][0] = (dp[i - 1][0] == 0 || obstacleGrid[i][0] == 1) ? 0 : 1;
        }

        for (int i = 1; i < y; i++) {
            for (int j = 1; j < x; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[y - 1][x - 1];
    }
}
