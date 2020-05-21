package com.leo.algorithm;

import com.leo.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/submissions/
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {28, 54, 7, -70, 22, 65, -6};
        int k = 100;
        int result = subarraySum2(nums, k);
        Utils.showResult("" + result);
    }

    /**
     * 这个可以得到所有集合
     */
    public static int subarraySum(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            subResult.clear();
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                int num = nums[j];
                sum += num;
                subResult.add(sum);
                if (sum == k) {
                    count++;
                    result.add(subResult);
                }
            }
        }
        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                int num = nums[j];
                sum += num;
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //======================官方标答==============================
    public int subarraySumOffice(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;

    }


}
