package com.leo.algorithm;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 0, 0, 0, 3, 3};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums3 = {1, 1, 2};
        int[] nums4 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums5 = {0, 0};
        int[] nums6 = {1, 1, 1, 2};
//        System.out.println(removeDuplicates(nums));
        int count = removeDuplicates2(nums4);
        showNums(count, nums4);
//        System.out.println(Arrays.toString(removeData(nums2, 1)));
    }

    //此方法移动整个数组 效率太低
    private static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int first = 0;
        int index = first;
        int temp = 0;
        int count = 0;
        for (int i = index; i < nums.length - 1; i++) {
            index++;
            if (nums[index] == nums[first]) {
                temp++;
            } else {
                count++;
                int newLength = nums.length - index;
                System.arraycopy(nums, index, nums, index - temp, newLength);
                first = index - temp;
                index = first;
                temp = 0;
            }
        }

        return count + 1;
    }

    //双指针法 单个赋值
    private static int removeDuplicates2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int count = 0;
        for (int i = count + 1; i < nums.length; i++) {
            if (nums[count] != nums[i]) {
                count++;
                nums[count] = nums[i];
            }
        }

        return count + 1;
    }

    private static void showNums(int count, int[] nums) {
        int[] aaa = new int[count];
        if (count >= 0) System.arraycopy(nums, 0, aaa, 0, count);
        System.out.println(Arrays.toString(aaa));
    }

    private static int[] removeData(int[] nums, int index) {
        int newLength = nums.length - index - 1;
        int[] newArry = new int[newLength + 1];
        System.arraycopy(nums, index + 1, nums, index, newLength);
        for (int i = 0; i < newArry.length; i++) {
            newArry[i] = nums[i];
        }
        return newArry;
    }
}
