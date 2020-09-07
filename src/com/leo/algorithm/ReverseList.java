package com.leo.algorithm;

import com.leo.algorithm.model.ListNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }

}
