package com.leo.algorithm;

import com.leo.algorithm.model.ListNode;
import com.leo.algorithm.model.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePrint {

    public static void main(String[] args) {
        Integer[] nums = {1, 3, 2};
        ListNode head = Utils.intToListNode(nums);
        int[] result = reversePrint1(head);
        com.leo.algorithm.utils.Utils.showResult(result);
    }

    /**
     * 击败14.11% 需改进
     *
     * @param head
     * @return
     */
    public static int[] reversePrint1(ListNode head) {

        Deque<Integer> stack = new ArrayDeque<>();

        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int index = 0;
        while (index < result.length) {
            result[index] = stack.getLast();
            stack.removeLast();
            index++;
        }
        return result;
    }


    public static int[] reversePrint2(ListNode head) {

        ListNode preNode = null;
        int count = 0;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = preNode;
            preNode = temp;
            count++;
        }

        int[] result = new int[count];

        int index = 0;
        while (preNode != null) {
            result[index] = preNode.val;
            preNode = preNode.next;
            index++;
        }

        return result;
    }
}
