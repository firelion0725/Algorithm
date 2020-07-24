package com.leo.algorithm;


import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 */
public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node t1 = head;
        while (t1 != null) {
            Node temp = new Node(t1.val);
            map.put(t1, temp);
            t1 = t1.next;
        }
        Node t2 = head;
        while (t2 != null) {
            Node temp = map.get(t2);
            if (temp != null) {
                if (t2.next != null) {
                    temp.next = map.get(t2.next);
                }
                if (t2.random != null) {
                    temp.random = map.get(t2.random);
                }
            }
            t2 = t2.next;
        }

        return map.get(head);
    }
}
