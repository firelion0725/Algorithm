package com.leo.algorithm;

import com.leo.algorithm.model.ListNode;
import com.leo.algorithm.utils.Utils;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode node = Utils.initListNode();
//        ListNode result = swapPairs(node);
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode result = swapNodesInPairs.helper2(node);
        Utils.showResult(result);
    }

    public static ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    private static ListNode helper(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode temp, nextNode;
        temp = node;
        nextNode = node.next;

        node = node.next;
        temp.next = helper(nextNode.next);
        node.next = temp;
        return node;
    }

    private ListNode helper2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = swap(head);
        newNode.next.next = helper2(next.next);
        return newNode;
    }

    private ListNode swap(ListNode node) {
        ListNode temp;
        temp = node;
        node = node.next;
        node.next = temp;
        return node;
    }
}
