package com.leo.algorithm;

import com.leo.algorithm.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 4};
        int[] num2 = {1, 3, 4};
        ListNode node1 = initListNode(num1);
        ListNode node2 = initListNode(num2);

        ListNode result = mergeTwoLists(node1, node2);
        showResult(result);
    }

    private static void showResult(ListNode result) {
        ListNode temp = result.next;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static ListNode initListNode(int[] nums) {
        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ListNode listNode = new ListNode(nums[i]);
            list.add(listNode);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result;
        if (l1 == null) {
            result = l2;
            return result;
        }

        if (l2 == null) {
            result = l1;
            return result;
        }
        if (l1.val <= l2.val) {
            result = l1;
            l1 = l1.next;
        } else {
            result = l2;
            l2 = l2.next;
        }
        merge(result, l1, l2);
        return result;
    }

    private static void merge(ListNode result, ListNode l1, ListNode l2) {
        if (result == null) {
            return;
        }
        if (l1 == null) {
            result.next = l2;
            return;
        }

        if (l2 == null) {
            result.next = l1;
            return;
        }
        if (l1.val <= l2.val) {
            result.next = l1;
            l1 = l1.next;
        } else {
            result.next = l2;
            l2 = l2.next;
        }
        merge(result.next, l1, l2);
    }

}
