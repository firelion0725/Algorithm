package com.leo.algorithm;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum s = new ThreeSum();
        s.threeSumOffice(nums);
    }

    //二重循环+hash 速度很不理想

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return new ArrayList<>();
        }

        Set<Integer> temp = new HashSet<>();
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            temp.clear();
            for (int j = i + 1; j < nums.length; j++) {
                if (temp.contains(target - nums[j])) {
                    List<Integer> list = Arrays.asList(-target, nums[j], target - nums[j]);
                    list.sort(Comparator.naturalOrder());
                    result.add(list);
                } else {
                    temp.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSumOffice(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();
        if (nums.length <= 2) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int target = nums[i];
            if (target > 0) {
                return result;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                if (target + b + c == 0) {
                    result.add(Arrays.asList(target, b ,c));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }
                if (target + b + c < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
