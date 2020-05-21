package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;
import com.leo.algorithm.model.Utils;

import java.util.LinkedList;
import java.util.Queue;

public class DepthBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = initTree2();
        int leftDeep = 0;
        int rightDeep = 0;
        int result = maxDepth(tree);
        System.out.println(result);
    }

    private static TreeNode initTree() {
        TreeNode root = new TreeNode(3);
        TreeNode tree2 = new TreeNode(9);
        TreeNode tree3 = new TreeNode(20);
        TreeNode tree4 = new TreeNode(15);
        TreeNode tree5 = new TreeNode(7);
        root.left = tree2;
        root.right = tree3;

        tree3.left = tree4;
        tree3.right = tree5;
        return root;
    }

    private static TreeNode initTree2() {
        Integer[] nums = {1, 2, 3, 4, null, null, 5};
//        Integer[] nums = {1, 2, 3};
        TreeNode treeNode = Utils.intToTree(nums);
        return treeNode;
    }

    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        result = nodeIntoQueue(result, queue);

        return result;
    }

    private static int nodeIntoQueue(int result, Queue<TreeNode> queue) {
        if (queue.isEmpty()) {
            return result;
        }
        result++;
        Queue<TreeNode> newQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                newQueue.add(node.left);
            }

            if (node.right != null) {
                newQueue.add(node.right);
            }
        }

        result = nodeIntoQueue(result, newQueue);
        return result;
    }

    /**
     * 标答
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }


    /**
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right==null){
            return 1;
        }
        int rightDepth = Integer.MAX_VALUE;
        int leftDepth = Integer.MAX_VALUE;
        if (root.right != null) {
            rightDepth = minDepth(root.right);
        }

        if (root.left != null) {
            leftDepth = minDepth(root.left);
        }
        return Math.min(rightDepth, leftDepth) + 1;
    }
}
