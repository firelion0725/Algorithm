package com.leo.algorithm;

import com.leo.algorithm.utils.Utils;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int result = 0;
        try {
            result = singleNumberOffice(nums);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Utils.showResult("" + result);
    }

    public static int singleNumber(int[] nums) throws Exception {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                return nums[i];
            }
            if (nums[i] != nums[i + 1]) {
                if (count == 0) {
                    return nums[i];
                }
                count = 0;
            } else {
                count++;
            }
        }
        throw new Exception("No single num");
    }

    //====================官方标答========================


    /**
     * 题目中只有一个数出现一次 其他都出现两次
     * 这是一个特定条件下的解法
     * （真阴）
     * @param nums
     * @return
     */
    public static int singleNumberOffice(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


}
