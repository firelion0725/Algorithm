package com.leo.algorithm;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        int count = 0;
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex] = nums[i];
                lastNonZeroIndex++;
                count++;
            }
        }
        int zeroCount = nums.length - count;
        for (int i = nums.length - 1; i >= nums.length - zeroCount; i--) {
            nums[i] = 0;
        }
    }

}
