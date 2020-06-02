package com.leo.algorithm;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int mid = (start + end) / 2;
        int left = helper(nums, start, mid);
        int right = helper(nums, mid + 1, end);

        if(left == right){
            return left;
        }

        int leftCount = getCount(nums, start, end, left);
        int rightCount = getCount(nums, start, end, right);

        return leftCount > rightCount ? left : right;
    }

    private int getCount(int[] nums, int start, int end, int num) {
        int result = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == num) {
                result++;
            }
        }
        return result;
    }
}
