package com.leo.algorithm;

import static com.leo.algorithm.utils.Utils.showResult;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = initArray();
        rotate(nums, 1);
//        showResult(nums);
    }

    private static int[] initArray() {
//        int[] aaa = {1, 2, 3, 4, 5, 6, 7};
        int[] aaa = {1};
        return aaa;
    }

    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        showResult(result);
    }

    //暴力法 空间复杂度0（1）
    public void rotate3(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        showResult(nums);
    }

    public void rotateOffice(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                //swap
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
        showResult(nums);
    }

    //==========================================================翻转数组法


    private void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k);
        reverse(nums, k + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int n1, int n2) {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }


}
