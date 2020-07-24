package com.leo.algorithm;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class IsStraight {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 5};
        IsStraight i = new IsStraight();
        i.isStraight(nums);
    }

    public boolean isStraight(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num != 0) {
                if (map.containsKey(num)) {
                    return false;
                }
                min = Math.min(num, min);
                max = Math.max(num, max);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int diff = max - min + 1;
        return diff <= 5;
    }

}
