package com.leo.algorithm.utils;

import com.leo.algorithm.model.ListNode;
import com.leo.algorithm.model.Node;
import com.leo.algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void showResult(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void showResult(String s) {
        System.out.println(s);
    }

    public static void showResult(boolean s) {
        System.out.println(s);
    }

    public static void showResult(TreeNode treeNode) {
        System.out.println(treeNode.toString());
    }


    public static void showResult(ListNode head) {
        while (head != null) {
            System.out.println(head.val + "====>");
            head = head.next;
        }

    }

    public static Node initNode() {
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

    public static TreeNode initTree() {
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

    public static TreeNode initTree(Integer[] data) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            TreeNode node = treeNode(data[i]);
            list.add(node);
        }
        for (int i = 0; i < list.size(); i++) {
            TreeNode item = list.get(i);
            if (item != null) {
                TreeNode left = null, right = null;
                try {
                    left = list.get(2 * i + 1);
                    right = list.get(2 * i + 2);
                } catch (Exception e) {

                }
                item.left = left;
                item.right = right;
            }
        }
        return list.get(0);
    }

    private static TreeNode treeNode(Integer val) {
        if (val == null) {
            return null;
        }
        return new TreeNode(val);
    }

    public static ListNode initListNode() {
        ListNode head = new ListNode(1);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(4);
        ListNode next5 = new ListNode(5);

        head.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;

        return head;
    }
}
