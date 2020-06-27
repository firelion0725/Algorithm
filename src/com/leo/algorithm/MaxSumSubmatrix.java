package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class MaxSumSubmatrix {

    public static void main(String[] args) {
        int[][] m = {{1, 0, 1}, {0, -2, 3}};
        MaxSumSubmatrix s = new MaxSumSubmatrix();
        s.maxSumSubmatrix(m,2);

    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        // O(cols ^ 2 * rows)
        for (int l = 0; l < cols; l++) { // 枚举左边界
            int[] rowSum = new int[rows]; // 左边界改变才算区域的重新开始
            max = all(matrix, cols, rows, l, rowSum, max, k);
        }
        return max;
    }

    //便利二位数组
    private int all(int[][] matrix, int cols, int rows, int start, int[] rowSum, int max, int k) {
        for (int r = start; r < cols; r++) {
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][r]);
                rowSum[i] += matrix[i][r];
            }
            // 求 rowSum 连续子数组的和
            // 和 尽量大，但不大于 k
            max = Math.max(max, dpmax(rowSum, k));
        }
        return max;
    }

    // 在数组 arr 中，求不超过 k 的最大值
    private int dpmax(int[] arr, int k) {
        // O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
            }
        }
        return max;
    }
}
