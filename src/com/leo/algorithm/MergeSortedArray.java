package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/submissions/
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[6];
        nums1[0] = 4;
//        nums1[1] = 5;
//        nums1[2] = 6;
        int[] nums2 = new int[5];
        nums2[0] = 1;
        nums2[1] = 2;
        nums2[2] = 3;
        nums2[3] = 5;
        nums2[4] = 6;

        merge2(nums1, 1, nums2, 5);
    }

    //引用一个空数组 比较两个值后放入空数组里 ， 最后新的数组再给nums1 赋值 并输出
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums = new int[n + m];

        int index1 = 0;
        int index2 = 0;

        while (index1 < m || index2 < n) {
            int num1 = 0;
            int num2 = 0;
            if (index1 < m) {
                num1 = nums1[index1];
            } else {
                num1 = Integer.MAX_VALUE;
            }

            if (index2 < n) {
                num2 = nums2[index2];
            } else {
                num2 = Integer.MAX_VALUE;
            }

            newNums[index1 + index2] = Math.min(num1, num2);

            if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }

        for (int i = 0; i < newNums.length; i++) {
            nums1[i] = newNums[i];
        }
    }


    //不引用第三个数组 存值 会出现 指针混乱的问题 一直没办法解决 无思路  暂缓
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        if (n == 0) {
            return;
        }


        int indexOld = 0;
        int index1 = 0;
        int index2 = 0;
        int len = Math.min(m, n);
        while (index1 < len && index2 < len) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1 <= num2) {
                indexOld++;
                index1++;
            } else {
                System.arraycopy(nums1, index1, nums1, index1 + 1, m - indexOld);
                nums1[index1] = nums2[index2];
                index2++;
                index1++;
            }
        }

        if (index2 <= index1) {
            System.arraycopy(nums2, index2, nums1, index1, n - index2);
        }
    }


}
