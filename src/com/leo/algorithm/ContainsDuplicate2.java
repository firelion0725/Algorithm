package com.leo.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicate2 {

    public static void main(String[] args) {
//        int[] nums = {99, 99};
//        int[] nums = {1, 2, 3, 1,2,3};
//        int[] nums = {1, 2, 3, 1, 4, 2, 3, 1};
        int[] nums = {1, 2};
        int k = 2;
        boolean result = containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        return checkDuplicate(nums, k);
    }

    //好像存在边界问题
    private static boolean checkDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length < 2) {
            return false;
        }
        int distance = k;
        if (nums.length <= k) {
            distance = 0;
        }
        int index = 0;
        while (index < nums.length - distance) {
            for (int i = index + 1; i <= index + k; i++) {
                if (nums[index] == nums[i]) {
                    return true;
                }
            }
            index++;
        }
        return false;
    }

    //-------------------官方标答======================================
    public boolean containsNearbyDuplicateOffice(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateOffice2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


}
