package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;
import com.leo.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class MinimumDistanceNodes {

    public static void main(String[] args) {
        TreeNode tree = Utils.initTree();
        int result = minDiffInBST(tree);
        Utils.showResult(String.valueOf(result));
    }


    public static int minDiffInBST(TreeNode root) {
//        return helper(root);

        List<Integer> sort = new ArrayList<>();
        sortHelper(sort, root);
        return minCheck(sort);
    }

    private static int minCheck(List<Integer> sort) {
        int result = Integer.MAX_VALUE;
        int start = 0;
        while (start < sort.size() - 1) {
            int diff = Math.abs(sort.get(start) - sort.get(start + 1));
            result = Math.min(result, diff);
            start++;
        }
        return result;
    }

    /**
     * 因为是二叉搜索树 所以中序必为升序
     *
     * @param tree
     * @return
     */
    private static List<Integer> sort(TreeNode tree) {
        List<Integer> result = new ArrayList<>();
        sortHelper(result, tree);
        return result;
    }

    private static void sortHelper(List<Integer> result, TreeNode tree) {
        if (tree.left != null) {
            sortHelper(result, tree.left);
        }
        result.add(tree.val);
        if (tree.right != null) {
            sortHelper(result, tree.right);
        }
    }


    /**
     * 这个写成了 求最小路径了 审题不行啊
     * 原题要的任意两点最小 （狗头）
     *
     * @param root
     * @return
     */
    private static int helper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftDistance = Integer.MAX_VALUE;
        int rightDistance = Integer.MAX_VALUE;
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDistance = Math.abs(root.val - root.left.val);
            leftDepth = helper(root.left);
        }

        if (root.right != null) {
            rightDistance = Math.abs(root.val - root.right.val);
            rightDepth = helper(root.right);
        }

        int min = Math.min(rightDistance, leftDistance);
        int minDepth = Math.min(leftDepth, rightDepth);
        return Math.min(min, minDepth);
    }
}
