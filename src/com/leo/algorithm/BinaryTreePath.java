package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;
import com.leo.algorithm.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

    public static void main(String[] args) {
        TreeNode root = Utils.initTree();
        List<String> list = binaryTreePaths(root);
        for (int i = 0; i < list.size(); i++) {
            Utils.showResult(list.get(i));
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return helper(String.valueOf(root.val), root);
    }

    private static List<String> helper(String buffer, TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(buffer);
            return result;
        }
        if (root.left != null) {
            String left = buffer + "->" + root.left.val;
            result.addAll(helper(left, root.left));
        }
        if (root.right != null) {
            String right = buffer + "->" + root.right.val;
            result.addAll(helper(right, root.right));
        }
        return result;
    }

}
