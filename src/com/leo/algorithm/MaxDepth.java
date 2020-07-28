package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int step) {
        if (root == null) {
            return step;
        }
        step++;
        int left = helper(root.left, step);
        int right = helper(root.right, step);
        return Math.max(left, right);
    }
}
