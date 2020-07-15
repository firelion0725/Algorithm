package com.leo.algorithm;

import com.leo.algorithm.utils.Utils;

import java.util.Arrays;
import java.util.Random;

import static com.leo.algorithm.utils.Utils.swap;

/**
 * https://blog.csdn.net/weixin_41190227/article/details/86600821
 */
public class Sort {

    public static void main(String[] args) {
        int[] nums1 = {1, 6, 98, 465, 5};
        int[] nums2 = {7, 6, 3, 88, 5, 100, 2, 1};

//        int[] result = selectionSort(nums2);
//        int[] result = QuickSort3(nums2, 0, nums2.length - 1);
        int[] result = quickSort4(nums2, 0, nums2.length - 1);
//        int[] result = nums2;
//        heapSort(result);
//        Utils.showResult(nums2);
        Utils.showResult(result);
    }

    /**
     * 冒泡排序
     * 是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        //遍历所有数组
        for (int i = 0; i < array.length; i++) {
            //循环后的数组 尾部位置为最高 无需再 处理
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 归并排序
     * 是建立在归并操作上的一种有效的排序算法。该算法是采用分治法。(本质是二分)
     * 不断递归自己的子序列 （排序） 再合并
     */
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    //归并排序——将两段排序好的数组结合成一个排序数组 (合并两个有序数组)
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < result.length; i++) {
            int num;
            int num1;
            int num2;
            if (index1 >= left.length) {
                num1 = Integer.MAX_VALUE;
            } else {
                num1 = left[index1];
            }
            if (index2 >= right.length) {
                num2 = Integer.MAX_VALUE;
            } else {
                num2 = right[index2];
            }
            if (num1 <= num2) {
                num = num1;
                index1++;
            } else {
                num = num2;
                index2++;
            }
            result[i] = num;
        }
        return result;
    }

    //简化式写法
    public static int[] merge2(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1; // (left + right) / 2

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    /**
     * 选择排序
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 以此类推，直到所有元素均排序完毕。
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (temp > array[j]) {
                    index = j;
                    temp = array[j];
                }
            }
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] QuickSort(int[] array) {
        if (array.length == 0) {
            return array;
        }

        int index = 0;
        int point = array[0];
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (num < point) {
                swap(array, i, index);
                index = i;
            }
        }
        return array;
    }

    /**
     * 快速排序
     */
    public static int[] QuickSort2(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            QuickSort2(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            QuickSort2(array, smallIndex + 1, end);
        }
        return array;
    }

    /**
     * 快速排序算法——partition
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        //拿到一个基准点
//        int pivot = (int) (start + Math.random() * (end - start + 1));
//        int pivot = (int) (start + end) / 2;
        int pivot = (int) start;
        //初始指针
        int smallIndex = start;
        //将基准点放末尾
        swap(array, pivot, end);

        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
                smallIndex++;
            }
        }
        return smallIndex;
    }

    //方法三 比较好理解
    public static int[] QuickSort3(int[] array, int start, int end) {
        //数列中的参照数字位置 将数列切成两部分进行递归
        int mark = helper3(array, start, end);
        if (mark > start) {
            QuickSort3(array, start, mark);
        }
        if (mark < end) {
            QuickSort3(array, mark + 1, end);
        }
        return array;
    }

    public static int helper3(int[] array, int start, int end) {
        if (start == end) {
            return start;
        }

        //指针靠拢方向 一开始 默认数字在头部 指针由尾部向头部靠拢
        boolean isAcc = false;
        //默认参照数字为第一个 将其拿出保存
        int temp = array[start];
        //首尾两指针不重合时开始循环运算
        while (start != end) {
            if (!isAcc) {
                if (array[end] > array[start]) {
                    end--;
                } else {
                    swap(array, start, end);
                    start++;
                    isAcc = true;
                }
            } else {
                if (array[start] < array[end]) {
                    start++;
                } else {
                    swap(array, start, end);
                    end--;
                    isAcc = false;
                }
            }
        }
        array[start] = temp;
        return start;
    }


    public static int[] quickSort4(int[] array, int begin, int end) {
        if (end <= begin) return array;
        int pivot = partition3(array, begin, end);
        quickSort4(array, begin, pivot - 1);
        quickSort4(array, pivot + 1, end);
        return array;
    }

    static int partition2(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                swap(a, counter, i);
                counter++;
            }
        }
        swap(a, pivot, counter);
        return counter;
    }

    static int partition3(int[] a, int begin, int end) {
        int i = begin;
        int j = end + 1;
        int v = a[begin];
        while (true) {
            while (a[++i] < v) if (i == end) break;
            while (v < a[--j]) if (j == begin) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, begin, j);
        return j;
    }

    //堆排序===========================================

    static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    public static void heapSort(int[] array) {
        if (array.length == 0) return;
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }


}