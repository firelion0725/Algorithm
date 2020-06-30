package com.leo.algorithm;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 */
public class ContainsNearbyDuplicate {

    //滑动窗口解法
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> datas = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int data = nums[i];
            if (datas.contains(data)) {
                return true;
            }
            datas.add(data);
            if (datas.size() > k) {
                datas.remove(nums[i - k]);
            }
        }
        return false;
    }

    //比滑动窗口 节省一步remove 不存在所谓的滑动了 靠记录下标并判断下标差求解
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> datas = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int data = nums[i];
            if (datas.containsKey(data) && Math.abs(i - datas.get(data)) <= k) {
                return true;
            }
            datas.put(data, i);
        }
        return false;
    }

}
