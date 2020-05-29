package com.leo.algorithm;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int result = rob(nums);
        System.out.println(result);
    }

    //动态规划
    private static int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int[] count = new int[nums.length];
        count[0] = nums[0];
        count[1] = Math.max(count[0],nums[1]);
        for (int i = 2; i < count.length; i++) {
            count[i] = Math.max(count[i - 2] + nums[i], count[i - 1]);
        }
        return count[count.length - 1];
    }
}
