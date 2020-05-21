package com.leo.algorithm;

import com.leo.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 */
public class ContainsDuplicate3 {

    public static void main(String[] args) {

//        int[] nums = {1, 5, 9, 1, 5, 9};
//        int[] nums = {1, 2, 3, 1, 3};
        int[] nums = {-1, 2147483647};
        int k = 1;
        int t = 2147483647;

        boolean result = containsNearbyDuplicate(nums, k, t);
        Utils.showResult(result);
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k, int t) {
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (check(set, nums[i], t)) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(0);
            }
        }
        return false;
    }

    private static boolean check(List<Integer> set, int num, int t) {
        for (Integer integer : set) {
            if (Math.abs(integer - num) <= t) {
                return true;
            }
        }
        return false;
    }


    public class Solution {
        // Get the ID of the bucket from element value x and bucket width w
        // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
        private long getID(long x, long w) {
            return x < 0 ? (x + 1) / w - 1 : x / w;
        }

        public boolean containsNearbyAlmostDuplicateOffice(int[] nums, int k, int t) {
            if (t < 0) {
                return false;
            }
            Map<Long, Long> d = new HashMap<>();
            long w = (long) t + 1;
            for (int i = 0; i < nums.length; ++i) {
                long m = getID(nums[i], w);
                // check if bucket m is empty, each bucket may contain at most one element
                if (d.containsKey(m)) {
                    return true;
                }
                // check the nei***or buckets for almost duplicate
                if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w) {
                    return true;
                }
                if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w) {
                    return true;
                }
                // now bucket m is empty and no almost duplicate in nei***or buckets
                d.put(m, (long) nums[i]);
                if (i >= k) {
                    d.remove(getID(nums[i - k], w));
                }
            }
            return false;
        }
    }
}