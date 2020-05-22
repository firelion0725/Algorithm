package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};
        TreeNode tree = buildTree(preorder, inorder);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(null, preorder, inorder);
    }

    private static TreeNode helper(TreeNode tree, int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        if (preorder.length == 1) {
            tree = new TreeNode(preorder[0]);
            return tree;
        }

        int headIndex = getHeadIndex(preorder[0], inorder);
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, headIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, headIndex + 1, inorder.length);
        tree = new TreeNode(preorder[0]);
        if (inorderLeft.length <= 1) {
            tree.left = inorderLeft.length == 1 ? new TreeNode(inorderLeft[0]) : null;
        } else {
            int[] preorderLeft = Arrays.copyOfRange(preorder, 1, headIndex+1);
            tree.left = helper(tree, preorderLeft, inorderLeft);
        }
        if (inorderRight.length <= 1) {
            tree.right = inorderRight.length == 1 ? new TreeNode(inorderRight[0]) : null;
        } else {
            int[] preorderRight = Arrays.copyOfRange(preorder, headIndex + 1, preorder.length);
            tree.right = helper(tree.right, preorderRight, inorderRight);
        }

        return tree;
    }

    private static int getHeadIndex(int head, int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (head == data[i]) {
                return i;
            }
        }
        return 0;
    }


}
