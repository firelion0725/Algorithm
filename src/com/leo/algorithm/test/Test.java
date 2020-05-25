package com.leo.algorithm.test;

import com.leo.algorithm.DesignCircularDeque;

public class Test {

    public static void main(String[] args) {
        deque();
    }

    private static void deque() {
        DesignCircularDeque deque = new DesignCircularDeque(3);
//        boolean r1 = deque.insertFront(3);
        boolean r1 = deque.insertLast(3);
        System.out.println(r1);
//        boolean r2 = deque.insertFront(4);
        boolean r2 = deque.insertLast(4);
        System.out.println(r2);
//        boolean r3 = deque.insertFront(5);
        boolean r3 = deque.insertLast(5);
        System.out.println(r3);
//        boolean r4 = deque.insertFront(6);
        boolean r4 = deque.insertLast(6);
        System.out.println(r4);

        int r5 = deque.getRear();
        System.out.println("" + r5);
        int r6 = deque.getFront();
        System.out.println("" + r6);

        deque.deleteFront();
        int r7 = deque.getFront();
        int r8 = deque.getRear();
        System.out.println("front:" + r7 + " ,last:" + r8);

        deque.deleteLast();
        int r9 = deque.getFront();
        int r10 = deque.getRear();
        System.out.println("front:" + r9 + " ,last:" + r10);

        deque.deleteLast();
        int r11 = deque.getFront();
        int r12 = deque.getRear();
        System.out.println("front:" + r11 + " ,last:" + r12);

        boolean r13 = deque.deleteLast();
        System.out.println(r13);
    }

    private static void test() {
        int[] nums1 = {5, 6, 7, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 5, 6, 8, 9};
        int m = 3;
        int n = 5;

        mergeOffice2(nums1, m, nums2, n);
    }

    public static void mergeOffice2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] < nums2[index2]) {
                nums1[index] = nums2[index2];
                index2--;
            } else {
                nums1[index] = nums1[index1];
                index1--;
            }
            index--;
        }

        System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
    }

}
