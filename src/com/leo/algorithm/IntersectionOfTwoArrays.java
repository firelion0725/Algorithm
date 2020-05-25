package com.leo.algorithm;

import com.leo.algorithm.utils.Utils;

import java.util.Arrays;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};

        int[] result = intersect(num1, num2);
        Utils.showResult(result);
    }


    /**
     * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k] = nums1[i];
                k++;
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

}
