package com.leo.algorithm;

import com.leo.algorithm.model.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal {

    public static void main(String[] args) {
        int[][] nums = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> triangle = Utils.arrayToList(nums);
        MinimumTotal m = new MinimumTotal();
        m.minimumTotal(triangle);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int s = list.size();
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            dp[i][s - 1] = triangle.get(i).get(s - 1) + dp[i - 1][triangle.get(i - 1).size() - 1];
            for (int j = 1; j < s - 1; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }

        int[] bottom = dp[n - 1];
        Arrays.sort(bottom);
        return bottom[0];
    }
}
