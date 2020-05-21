package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树排序
 */
public class BinaryTreeOrder {

    public static void main(String[] args) {
        TreeNode treeNode = initTree();
//        List<Integer> list = preorderTraversal(treeNode);
//        List<Integer> list = inorderTraversal(treeNode);
        List<Integer> list = postOrderTraversal(treeNode);
        showResult(list);
    }

    private static TreeNode initTree() {
        TreeNode treeRoot = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
//        TreeNode tree4 = new TreeNode(5);

        treeRoot.right = tree2;
        tree2.left = tree3;

        return treeRoot;
    }

    static List<Integer> result = new ArrayList<>();

    /**
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/submissions/
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        treeInListPreOrder(result, root);
        return result;
    }

    private static void treeInListPreOrder(List<Integer> result, TreeNode root) {
        result.add(root.val);
        if (root.left != null) {
            treeInListPreOrder(result, root.left);
        }
        if (root.right != null) {
            treeInListPreOrder(result, root.right);
        }
    }

    /**
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        treeInListInOrder(result, root);
        return result;
    }

    private static void treeInListInOrder(List<Integer> result, TreeNode root) {
        if (root.left != null) {
            treeInListInOrder(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            treeInListInOrder(result, root.right);
        }
    }

    /**
     * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
     */
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        treeInListPostOrder(result, root);
        return result;
    }

    private static void treeInListPostOrder(List<Integer> result, TreeNode root) {
        if (root.left != null) {
            treeInListPostOrder(result, root.left);
        }

        if (root.right != null) {
            treeInListPostOrder(result, root.right);
        }

        result.add(root.val);
    }


    private static void showResult(List<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
