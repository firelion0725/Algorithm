package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (A.val == B.val && (helper(A.left, B.left) && helper(A.right, B.right))) {
            return true;
        }
        return isSubStructure2(A.left, B) || isSubStructure2(A.right, B);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return helper(root1.left, root2.left) && helper(root1.right, root2.right);
        } else {
            return false;
        }
    }

}
