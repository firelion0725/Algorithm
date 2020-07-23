package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;
import com.leo.algorithm.model.Utils;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = Utils.intToTree(nums);
        int sum = 22;
        PathSum p = new PathSum();
        p.pathSum(root, sum);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        list.add(root.val);
        if (root.val == sum && (root.left == null && root.right == null)) {
            res.add(new ArrayList<>(list));
        } else {
            if (root.left != null) {
                helper(res, list, root.left, sum - root.val);
            }

            if (root.right != null) {
                helper(res, list, root.right, sum - root.val);
            }
        }
        list.remove(list.size() - 1);
    }
}
