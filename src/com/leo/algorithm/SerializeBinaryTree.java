package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeBinaryTree {

    // Encodes a tree to a single string.
    //广度优先遍历
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == null) {
                    stringBuilder.append("null");
                    stringBuilder.append(",");
                } else {
                    stringBuilder.append(node.val);
                    stringBuilder.append(",");
                    stack.add(root.left);
                    stack.add(root.right);
                }

            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String temp = data.replace("[", "").replace("]", "");
        String[] strings = temp.split(",");
        List<TreeNode> nodes = new ArrayList<>();
        for (String s : strings) {
            if (!s.equals("null")) {
                TreeNode node = new TreeNode(Integer.valueOf(s));
                nodes.add(node);
            } else {
                nodes.add(null);
            }
        }

        for (int i = 0; i < nodes.size(); i++) {
            TreeNode n = nodes.get(i);
            if (n != null) {
                if (2 * i < nodes.size()) {
                    n.left = nodes.get(2 * i);
                }
                if (2 * i + 1 < nodes.size()) {
                    n.right = nodes.get(2 * i + 1);
                }
            }
        }
        return nodes.get(0);
    }
}
