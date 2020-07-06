package com.leo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backTrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backTrack(List<String> res, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            backTrack(res, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            backTrack(res, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }



}
