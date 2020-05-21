package com.leo.algorithm;

import com.leo.algorithm.model.ListNode;
import com.leo.algorithm.utils.Utils;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode node = Utils.initListNode();

        ListNode result = reverseKGroup(node, 3);
        Utils.showResult(result);
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) {
            return head;
        }
        return helper(head, k - 1);
    }

    private static ListNode helper(ListNode head, int k) {
        ListNode start = head, end = head;
        int index = 0;
        for (index = 0; index < k; ++index) {
            if (end == null) {
                break;
            }
            end = end.next;
        }

        if (index != k || end == null) {
            return head;
        }

        ListNode node = end.next;
        end.next = null;
        reverse(start);
        start.next = helper(node, k);
        return end;
    }

    private static ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode temp = node;
            node = node.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }

}
