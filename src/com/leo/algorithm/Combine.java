package com.leo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private void backTrace(int n, int k, int start, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            backTrace(n, k, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }


}
