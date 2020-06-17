package com.leo.algorithm;

import java.util.Arrays;

//三大排序算法
public class ThreeSortWay {

    public static void main(String[] args) {
        int[] nums = {20, 1, 2, 45, 7, 8, 9, 4, 5545, 3};
        ThreeSortWay s = new ThreeSortWay();
//        s.quickSort(nums);
//        s.show(nums);
//        int[] result = s.mergeSort(nums);
//        s.show(result);
        s.heapSort(nums);
        s.show(nums);
    }

//=================================================

    private void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (end == start) {
            return;
        }
        int mid = helper(array, start, end);
        if (mid > start) {
            quickSort(array, start, mid);
        }
        if (mid < end) {
            quickSort(array, mid + 1, end);
        }
    }

    private int helper(int[] array, int start, int end) {
        if (end == start) {
            return start;
        }
        int t = array[start];
        boolean isAc = false;
        while (start < end) {
            if (!isAc) {
                if (array[start] < array[end]) {
                    end--;
                } else {
                    int temp = array[start];
                    array[start] = array[end];
                    array[end] = temp;
                    start++;
                    isAc = true;
                }
            } else {
                if (array[end] > array[start]) {
                    start++;
                } else {
                    int temp = array[end];
                    array[end] = array[start];
                    array[start] = temp;
                    end--;
                    isAc = false;
                }
            }
        }
        array[start] = t;
        return start;
    }

//=========================================

    private int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        for (int i = 0, l = 0, r = 0; i < result.length; i++) {
            if (l >= left.length) {
                result[i] = right[r++];
            } else if (r >= right.length) {
                result[i] = left[l++];
            } else if (left[l] < right[r]) {
                result[i] = left[l++];
            } else {
                result[i] = right[r++];
            }
        }
        return result;
    }

//=========================================================

    private void heapSort(int[] array) {
        int l = array.length;

        for (int i = l / 2 - 1; i >= 0; i--) {
            heapify(array, l, i);
        }

        for (int i = l - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    //调整堆 ， n为size i为节点
    private void heapify(int[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest]) {
            largest = l;
        }

        if(r<n && array[r] > array[largest]){
            largest = r;
        }

        if(largest != i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array,n,largest);
        }

    }

//========================================================


    private void show(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
