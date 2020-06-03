package com.leo.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        permutations.permute(nums);
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

    //不成功。。。。
    public void backtrackOffice(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n)
            res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrackOffice(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

}
