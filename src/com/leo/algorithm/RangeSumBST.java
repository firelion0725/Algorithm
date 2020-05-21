package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;
import com.leo.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumBST {

    public static void main(String[] args) {
        Integer[] data = {10, 5, 15, 3, 7, 13, 18, 1, null, 6};
        TreeNode tree = Utils.initTree(data);
        int sum = rangeSumBST(tree, 6, 10);
        System.out.println(sum);
    }

    private static TreeNode initTree() {
        TreeNode root = new TreeNode(10);
        TreeNode tree2 = new TreeNode(5);
        TreeNode tree3 = new TreeNode(15);
        TreeNode tree4 = new TreeNode(3);
        TreeNode tree5 = new TreeNode(7);
        TreeNode tree6 = new TreeNode(18);

        root.left = tree2;
        root.right = tree3;

        tree2.left = tree4;
        tree2.right = tree5;

        tree3.right = tree6;
        return root;
    }

    private static List<Integer> list = new ArrayList<>();
    static int sum = 0;

    public static int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        helper(root, L, R);
        return sum;
    }

    private static void helper(TreeNode root, int L, int R) {
        if (root.left != null) {
            helper(root.left, L, R);
        }

        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        if (root.right != null) {
            helper(root.right, L, R);
        }
    }

}
