package com.leo.algorithm;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int result = rob(nums);
        System.out.println(result);
    }

    //动态规划
    private static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] count = new int[nums.length];
        count[0] = nums[0];
        count[1] = Math.max(count[0], nums[1]);
        for (int i = 2; i < count.length; i++) {
            count[i] = Math.max(count[i - 2] + nums[i], count[i - 1]);
        }
        return count[count.length - 1];
    }

    //动态规划
    private static int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] count1 = new int[nums.length];
        int[] count2 = new int[nums.length];
        //抢第一个房子
        count1[0] = nums[0];
        count1[1] = Math.max(count1[0], nums[1]);
        //不能抢最后一个
        for (int i = 2; i < count1.length - 1; i++) {
            count1[i] = Math.max(count1[i - 2] + nums[i], count1[i - 1]);
        }

        //抢最后一个
        count2[nums.length - 1] = nums[nums.length - 1];
        count2[nums.length - 2] = Math.max(count2[nums.length - 1], nums[nums.length - 2]);
        //不抢第一个房子
        for (int i = nums.length - 3; i > 0; i--) {
            count2[i] = Math.max(count2[i + 2] + nums[i], count2[i + 1]);
        }

        return Math.max(count1[nums.length - 2], count2[1]);
    }
}
