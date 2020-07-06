package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end || start < 0) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = helper(nums, start, mid - 1);
        TreeNode right = helper(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
