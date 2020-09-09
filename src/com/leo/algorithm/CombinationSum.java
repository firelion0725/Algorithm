package com.leo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/solution/
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates);
        backTrance(candidates, target, res, combine, 0, 0);
        return res;
    }

    private void backTrance(int[] candidates, int target, List<List<Integer>> res, List<Integer> combine, int sum, int begin) {

        if (target == sum) {
            res.add(new ArrayList<>(combine));
        }

        for (int i = begin; i < candidates.length; i++) {
            int rs = candidates[i] + sum;
            if (rs <= target) {
                combine.add(candidates[i]);
                backTrance(candidates, target, res, combine, rs, i);
                combine.remove(combine.size() - 1);
            } else {
                break;
            }
        }
    }
}
