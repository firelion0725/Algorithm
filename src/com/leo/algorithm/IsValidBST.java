package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);
        if (list.size() < 2) {
            return true;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private void helper(TreeNode node, ArrayList<Integer> list) {
        if (node.left != null) {
            helper(node.left, list);
        }

        list.add(node.val);

        if (node.right != null) {
            helper(node.right, list);
        }
    }

    //===================================================================

    long lastval = Long.MIN_VALUE;//初始化一个最小值

    public boolean isValidBST2(TreeNode root) {
        return helper2(root);
    }

    public boolean helper2(TreeNode root) {

        if (root == null) {//根节点为空，则返回true
            return true;
        }
        if (!helper2(root.left)) {//先遍历左子树
            return false;
        }
        if (root.val <= lastval) {//中序遍历一个特征就是遍历的树会从小到大排列，所以如果当前值小于上一个值，则返回false
            return false;
        }
        lastval = (long) root.val;//并将上一个值换成当前值
        if (!helper2(root.right)) {//遍历右子树
            return false;
        }
        return true;
    }

}
