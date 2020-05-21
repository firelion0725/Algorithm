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

    //=================================================================

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeOffice(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 最强解
     */
    public void mergeOffice2(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /**
     * 最强解菜狗版
     */
    public void mergeByMyself(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index] < nums2[index2]) {
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
