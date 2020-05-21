package com.leo.algorithm;

import com.leo.algorithm.model.ListNode;
import com.leo.algorithm.utils.Utils;

public class ReverseListNode {

    public static void main(String[] args) {
        ListNode node = Utils.initListNode();
        reverseListNode(node);
    }

    private static ListNode reverseListNode(ListNode node) {
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
