package com.leo.algorithm;

import com.leo.algorithm.model.TreeNode;
import com.leo.algorithm.utils.Utils;

import java.util.*;

public class LowestCommonAncestor {

    public static TreeNode initTree() {
        TreeNode root = new TreeNode(3);
        TreeNode tree2 = new TreeNode(5);
        TreeNode tree3 = new TreeNode(1);
        TreeNode tree4 = new TreeNode(6);
        TreeNode tree5 = new TreeNode(2);
        TreeNode tree6 = new TreeNode(0);
        TreeNode tree7 = new TreeNode(8);
        TreeNode tree8 = new TreeNode(7);
        TreeNode tree9 = new TreeNode(4);

        root.left = tree2;
        root.right = tree3;

        tree2.left = tree4;
        tree2.right = tree5;

        tree3.left = tree6;
        tree3.right = tree7;

        tree5.left = tree8;
        tree5.right = tree9;

        return root;
    }

    public static TreeNode initTree2() {
        TreeNode root = new TreeNode(2);
        TreeNode tree3 = new TreeNode(1);
        root.right = tree3;
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = initTree();
        TreeNode tree4 = new TreeNode(2);
        TreeNode tree5 = new TreeNode(1);
        TreeNode tree = lowestCommonAncestor(root, tree4, tree5);
        Utils.showResult(tree);

    }

    private static HashMap<Integer, TreeNode> map = new HashMap<>();

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root);
        return treeToStack(p, q);
    }

    /**
     * 遍历整个树 并记录子节点与根的映射
     */
    private static void helper(TreeNode node) {
        if (node.left != null) {
            helper(node.left);
            map.put(node.left.val, node);
        }

        if (node.right != null) {
            helper(node.right);
            map.put(node.right.val, node);
        }
    }

    /**
     * 将树转成数组
     *
     * @param node
     * @return
     */
    private static TreeNode treeToStack(TreeNode node, TreeNode q) {
        LinkedList<TreeNode> link = new LinkedList<TreeNode>();

        TreeNode item = node;
        link.add(item);
        while (item != null) {
            item = map.get(item.val);
            if (item != null) {
                link.add(item);
            }
        }

        while (q != null) {
            if (link.contains(q)) {
                return q;
            }
            q = map.get(q.val);
        }

        return null;
    }

    /**
     * 循环查找是否存在公共跟
     *
     * @param tree1
     * @param tree2
     * @return
     */
    private static TreeNode checkComm(LinkedList<TreeNode> tree1, LinkedList<TreeNode> tree2) {
        TreeNode node = tree1.poll();
        while (node != null) {
            if (tree2.contains(node)) {
                return node;
            }
            node = tree1.poll();
        }
        return null;
    }

//    private static boolean containsInTree(TreeNode node, LinkedList<TreeNode> treeList) {
//        Integer val = node.val;
//        TreeNode item = treeList.poll();
//        while (item != null) {
//            if (item.val.equals(val)) {
//                return true;
//            }
//            item = treeList.poll();
//        }
//        return false;
//    }

    //=============================================

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestorOffice(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

}