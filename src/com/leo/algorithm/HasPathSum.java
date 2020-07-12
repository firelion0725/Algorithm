package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;
import com.leo.algorithm.utils.Utils;

/**
 * https://leetcode-cn.com/problems/path-sum/
 */
public class HasPathSum {

    public static void main(String[] args) {

        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        TreeNode tree = Utils.initTree(nums);

        HasPathSum hasPathSum = new HasPathSum();
        hasPathSum.hasPathSum(tree, 22);

    }


    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.right == null && root.left == null && root.val == sum) {
            return true;
        }

        boolean left = false;
        boolean right = false;

        if (root.left != null) {
            left = helper(root.left, sum - root.val);
        }

        if (root.right != null) {
            right = helper(root.right, sum - root.val);
        }

        return left || right;
    }
}
