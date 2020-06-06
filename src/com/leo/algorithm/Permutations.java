package com.leo.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {

    public static void main(String[] args) {
        test2();
    }

    private void test() {
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        permutations.permute(nums);
    }

    private static void test2() {
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        permutations.permuteOffice(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, nums, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(List<List<Integer>> result, int[] nums, int begin, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            backTrack(result, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    //不成功。。。。
    private void backTrack2(List<List<Integer>> result, int[] nums, int begin, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i < nums.length; i++) {

            list.add(nums[i]);

            backTrack2(result, nums, begin + 1, list);
            // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
            list.remove(list.size() - 1);
        }

    }

    //==============================================================================

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteOffice(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     *
     * @param nums
     * @param track
     */
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }


}
