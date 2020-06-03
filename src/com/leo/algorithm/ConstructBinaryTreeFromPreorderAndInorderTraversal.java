package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {1, 2, 3};
        int[] inorder = {3, 2, 1};
        TreeNode tree = buildTreeOffice(preorder, inorder);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder);
    }

    private static TreeNode helper(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode tree;
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
            int[] preorderLeft = Arrays.copyOfRange(preorder, 1, headIndex + 1);
            tree.left = helper(preorderLeft, inorderLeft);
        }
        if (inorderRight.length <= 1) {
            tree.right = inorderRight.length == 1 ? new TreeNode(inorderRight[0]) : null;
        } else {
            int[] preorderRight = Arrays.copyOfRange(preorder, headIndex + 1, preorder.length);
            tree.right = helper(preorderRight, inorderRight);
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

    //======================================OFFICE==============================================================

    /**
     * @param indexMap       中序数组 值为K 下表为V
     * @param preorder       前序数组
     * @param preorder_left  前序左边界
     * @param preorder_right 前序右边界
     * @param inorder_left   中序左边界
     * @return 生成的树
     */
    public static TreeNode helper(Map<Integer, Integer> indexMap, int[] preorder, int preorder_left, int preorder_right, int inorder_left) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 通过前序的值获取中序的位置
        int inorder_root = indexMap.get(preorder[preorder_left]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_left]);

        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = helper(indexMap, preorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = helper(indexMap, preorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1);
        return root;
    }

    public static TreeNode buildTreeOffice(int[] preorder, int[] inorder) {
        // 构造哈希映射，帮助我们快速定位根节点
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(indexMap, preorder, 0, preorder.length - 1, 0);
    }

}
