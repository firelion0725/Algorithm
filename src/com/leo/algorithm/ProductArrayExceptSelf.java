package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {4,5,1,8,2};
        ProductArrayExceptSelf p = new ProductArrayExceptSelf();
        p.productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[right.length - 1] = 1;
        for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
            left[i] = left[i - 1] * nums[i-1];
            right[j] = right[j + 1] * nums[j+1];
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }


//    private void backTrack(int[] result, int[] nums, int begin, int sum, int count) {
//        if (count == nums.length) {
//            result[begin] = sum;
//            return;
//        }
//
//        for (int i = begin; i < nums.length; i++) {
//            sum *= nums[begin];
//            count++;
//            backTrack(result, nums, begin, sum, count);
//
//        }
//    }
}
