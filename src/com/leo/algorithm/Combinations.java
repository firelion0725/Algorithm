package com.leo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode/
 */
public class Combinations {

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(result, n, k, 1, new Stack<>());
        return result;
    }

    private void findCombinations(List<List<Integer>> result, int n, int k, int begin, Stack<Integer> pre) {
        if (pre.size() == k) {
            result.add(new ArrayList<>(pre));
            return;
        }

        for (int i = begin; i < n; i++) {
            pre.add(i);
            findCombinations(result, n, k, i + 1, pre);
            pre.pop();
        }
    }


}
