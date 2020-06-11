package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//        int[][] matrix = {{1, 3}};
        SearchMatrix s = new SearchMatrix();
        boolean result = s.searchMatrix(matrix, 20);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if ((matrix.length == 1 && matrix[0].length == 0)
                || matrix.length == 0
                || target < matrix[0][0]
                || target > matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1]) {
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;


        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (target < matrix[mid][0]) {
                right = mid - 1;
            } else if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
                return searchArray(matrix[mid], target);
            } else {
                left = mid + 1;
            }
        }

        return searchArray(matrix[left], target);
    }

    private boolean searchArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left] == target;
    }
}
