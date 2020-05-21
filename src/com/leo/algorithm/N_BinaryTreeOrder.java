package com.leo.algorithm;

import com.leo.algorithm.model.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N 叉树的遍历
 */
public class N_BinaryTreeOrder {

    public static void main(String[] args) {
        Node tree = initTree();
//        List<Integer> list = preorder(tree);
//        List<Integer> list = postOrder(tree);
//        showResult(list);

        List<List<Integer>> result = levelOrder2(tree);
        showResult2(result);
    }

    private static Node initTree() {
        Node treeRoot = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        List<Node> list3 = new ArrayList<>();
        list3.add(node5);
        list3.add(node6);

        node3.children = list3;

        List<Node> listRoot = new ArrayList<>();
        listRoot.add(node3);
        listRoot.add(node2);
        listRoot.add(node4);
        treeRoot.children = listRoot;

        return treeRoot;
    }

    /**
     * 前序遍历
     * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/submissions/
     */
    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        nodeIntoTreePreOrder(result, root);
        return result;
    }

    private static void nodeIntoTreePreOrder(List<Integer> result, Node root) {
        result.add(root.val);
        if (root.children != null && root.children.size() > 0) {
            for (Node node : root.children) {
                nodeIntoTreePreOrder(result, node);
            }
        }
    }

    /**
     * 后序遍历
     * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
     */
    public static List<Integer> postOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        nodeIntoTreePostOrder(result, root);
        return result;
    }

    private static void nodeIntoTreePostOrder(List<Integer> result, Node root) {

        if (root.children != null && root.children.size() > 0) {
            for (Node node : root.children) {
                nodeIntoTreePostOrder(result, node);
            }
        }
        result.add(root.val);
    }

    /**
     * 层序遍历
     * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
     */
    public static List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        //处理根
        queue.add(root);
        //处理节点
        readLevel(result, queue);
        return result;
    }

    private static void readLevel(List<List<Integer>> result, Queue<Node> queue) {
        if (queue.isEmpty()) {
            return;
        }
        List<Integer> level = new ArrayList<>();
        Queue<Node> newQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            level.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                newQueue.addAll(node.children);
            }
        }
        result.add(level);
        readLevel(result, newQueue);
    }

    /**
     * 层序遍历 标答
     * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
     */
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    if (node.children != null) {
                        queue.addAll(node.children);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }

    private static void showResult(List<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static void showResult2(List<List<Integer>> list) {
        for (List<Integer> l : list) {
            for (int i = 0; i < l.size(); i++) {
                if (i < l.size() - 1) {
                    System.out.print(l.get(i) + ",");
                } else {
                    System.out.println(l.get(i));
                }
            }
        }
    }

}
