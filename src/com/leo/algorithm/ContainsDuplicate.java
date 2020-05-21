package com.leo.algorithm;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 4, 2, 3, 1};
        boolean result = containsDuplicate(nums);
        System.out.println(result);
    }

    public static boolean containsDuplicate(int[] nums) {
        int[] newNums = sort(nums);
        return checkDuplicate(newNums);
    }

    private static boolean checkDuplicate(int[] nums) {
        int index = 0;
        while (index < nums.length - 1) {
            if (nums[index] == nums[index + 1]) {
                return true;
            }
            index++;
        }
        return false;
    }

    //归并排序
    private static int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;

        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;

        for (int i = 0; i < result.length; i++) {
            if (index1 >= nums1.length) {
                num1 = Integer.MAX_VALUE;
            } else {
                num1 = nums1[index1];
            }
            if (index2 >= nums2.length) {
                num2 = Integer.MAX_VALUE;
            } else {
                num2 = nums2[index2];
            }

            if (num1 < num2) {
                result[i] = num1;
                index1++;
            } else {
                result[i] = num2;
                index2++;
            }
        }

        return result;
    }
}
