package com.leo.algorithm;

import java.util.*;

//多数和
public class Sum {

    public static void main(String[] args) {
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        Sum s = new Sum();
        s.threeSum(nums);


//        int[] nums = {1, 1, 2, 2, -1, -1, 0, 6, -4, -6};
//        Arrays.sort(nums);
//        s.helperTwoSum(nums, 0, nums.length - 1, 0, null);
    }

    /**
     * https://leetcode-cn.com/problems/two-sum/
     *
     * @return 返回数据下标的数组
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int d = nums[i];
            if (map.containsKey(target - d)) {
                res[0] = i;
                res[1] = map.get(target - d);
                return res;
            }
            map.put(d, i);
        }

        return res;
    }

    /**
     * https://leetcode-cn.com/problems/3sum/
     *
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        return threeSum(nums, 0);
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        Set<List<Integer>> tRes = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int d = nums[i];
            List<List<Integer>> list = helperTwoSum(nums, i + 1, nums.length - 1, target - d);
            if (list.size() > 0) {
                for (List<Integer> l : list) {
                    l.add(0, d);
                    tRes.add(l);
                }
            }
        }

        return new ArrayList<>(tRes);
    }

    /**
     * 进来必须为有序数组
     *
     * @return 返回数据的数组
     */
    public List<List<Integer>> helperTwoSum(int[] nums, int begin, int end, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (begin < 0 || end > nums.length - 1) {
            return res;
        }
        int left = begin;
        int right = end;

        while (left < right) {
            int d = nums[left] + nums[right];
            if (target == d) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(list);
                right--;
                left++;
            } else if (d < target) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }

    /**
     * 进来必须为有序数组
     *
     * @return 返回数据的数组
     */
    public List<List<Integer>> helperTwoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return helperTwoSum(nums, left, right, target);
    }

    //================================================================================

    private List<List<Integer>> threeSumOffice(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> tres = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[i] + nums[right] + nums[right - 1] < target) {
                continue;
            }
            if (nums[i] + nums[left] + nums[left + 1] > target) {
                continue;
            }

            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right] - target;
                if (temp == target) {
                    Integer[] tarray = {nums[i], nums[left], nums[right]};
                    List<Integer> list = Arrays.asList(tarray);
                    tres.add(list);
                    right--;
                    left++;
                } else if (temp > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        res.addAll(tres);
        return res;
    }
}
