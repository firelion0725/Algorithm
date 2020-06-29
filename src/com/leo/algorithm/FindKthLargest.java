package com.leo.algorithm;

import java.util.Arrays;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - 1 - k];
    }
}
