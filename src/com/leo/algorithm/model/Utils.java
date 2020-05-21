package com.leo.algorithm.model;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static TreeNode intToTree(Integer[] nums) {
        List<TreeNode> list = new ArrayList<>();
        for (Integer num : nums) {
            TreeNode node = new TreeNode(num);
            list.add(node);
        }
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            TreeNode left;
            TreeNode right;
            try {
                left = list.get(i * 2 + 1);
            } catch (Exception e) {
                left = null;
            }

            try {
                right = list.get(i * 2 + 2);
            } catch (Exception e) {
                right = null;
            }
            if (left != null) {
                node.left = left;
            }
            if (right != null) {
                node.right = right;
            }
        }
        return list.get(0);
    }

}
