package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMin {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        FindMin f = new FindMin();
        f.findMin(nums);
    }

    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = (left + right) / 2;

        int leftMin = helper(nums, left, mid);
        int rightMin = helper(nums,mid+1, right);

        return Math.min(leftMin, rightMin);
    }
}
