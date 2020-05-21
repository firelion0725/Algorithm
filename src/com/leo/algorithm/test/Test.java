package com.leo.algorithm.test;

public class Test {

    public static void main(String[] args) {
        int[] nums1 = {5, 6, 7,0,0,0,0,0};
        int[] nums2 = {1, 5, 6, 8, 9};
        int m = 3;
        int n = 5;

        mergeOffice2(nums1, m, nums2, n);
    }

    public static void mergeOffice2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m+n-1;

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
