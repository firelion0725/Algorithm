package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;
import com.leo.algorithm.model.Utils;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = initTree2();
        boolean aaa = isValidBST3(root);
//        System.out.println(aaa);
    }

    private static TreeNode initTree() {
        TreeNode root = new TreeNode(2);
        TreeNode tree2 = new TreeNode(1);
        TreeNode tree3 = new TreeNode(3);
        root.left = tree2;
        root.right = tree3;
        return root;
    }

    private static TreeNode initTree2() {
//        Integer[] nums = {2, 1, 3};
        Integer[] nums = {10, 5, 15, null, 7, 6, 20};
        TreeNode treeNode = Utils.intToTree(nums);
        return treeNode;
    }

//    public static boolean isValidBST(TreeNode root) {
//
//        if (root == null) {
//            return true;
//        }
//
//        return validRoot(root, root, root);
//    }

//    public static boolean validRoot(TreeNode up, TreeNode low, TreeNode root) {
//
//    }

//    public static boolean isValidBST(TreeNode root) {
//
//        if (root.left == null && root.right == null) {
//            return true;
//        }
//
//        boolean result = true;
//        if (root.left != null) {
//            if (root.left.val >= root.val) {
//                return false;
//            } else {
//                result = isValidBST(root.left);
//            }
//        }
//
//        if (!result) {
//            return false;
//        }
//
//        if (root.right != null) {
//            if (root.right.val <= root.val) {
//                return false;
//            } else {
//                result = isValidBST(root.right);
//            }
//        }
//
//        return result;
//    }


    //==============================标答=====================================
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }

    //==================中序递归==============================
    private static double pre = -Double.MAX_VALUE;

    public static boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Inorder(root);
    }

    private static boolean Inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!Inorder(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        } else {
            pre = root.val;
        }

        if (!Inorder(root.right)) {
            return false;
        }
        return true;
    }

}
