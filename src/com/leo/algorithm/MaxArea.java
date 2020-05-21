package com.leo.algorithm;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        showResult(maxArea(nums));
    }

    private static void showResult(int max) {
        System.out.println(max);
    }

    private static int maxArea(int[] nums) {
        if(nums == null|| nums.length<2){
            return 0;
        }
        int maxArea = 0;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int left = nums[leftIndex];
            int right = nums[rightIndex];
            int width = rightIndex - leftIndex;
            int height = Math.min(left, right);
            if (maxArea < width * height) {
                maxArea = width * height;
            }

            if (left > right) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return maxArea;
    }
}
