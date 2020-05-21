package com.leo.algorithm;

import com.leo.algorithm.model.ListNode;
import com.leo.algorithm.utils.Utils;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode node = Utils.initListNode();
        ListNode result = swapPairs(node);
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
}
