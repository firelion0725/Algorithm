package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;
import com.leo.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode node = initTree();
        boolean result = isSymmetric(node);
        Utils.showResult(result);
    }

    private static TreeNode initTree() {
        TreeNode treeRoot = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(2);
        TreeNode tree4 = new TreeNode(3);
        TreeNode tree5 = new TreeNode(3);

        treeRoot.right = tree2;
        treeRoot.left = tree3;

        tree2.right = tree4;
        tree3.right = tree5;

        return treeRoot;
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);

        //中序法是不对的。。。。
//        //中序遍历成字符串
//        List<Integer> list = treeIntoNums(root);
//        if (list.size() <= 1) {
//            return true;
//        }
//        int start = 0;
//        int end = list.size() - 1;
//        while (start != end) {
//            int nums1 = list.get(start);
//            int num2 = list.get(end);
//            if (nums1 != num2) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
    }

    private static List<Integer> treeIntoNums(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    private static void helper(List<Integer> result, TreeNode root) {
        if (root.left != null) {
            helper(result, root.left);
        } else if (root.right != null) {
            result.add(Integer.MIN_VALUE);
        }
        result.add(root.val);
        if (root.right != null) {
            helper(result, root.right);
        } else if (root.left != null) {
            result.add(Integer.MIN_VALUE);
        }
    }

    //================官方答案======================

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
