package com.leo.algorithm;

import com.leo.algorithm.utils.Utils;

import java.util.ArrayDeque;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3, 5, 2, 3, 1, 2};
        int[] result = maxSlidingWindow(nums, 3);
        Utils.showResult(result);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        if (k == 0) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        if (nums.length - k + 1 < 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);

        for (int i = 0, j = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            deque.addLast(nums[i]);
            if (deque.size() >= k) {
                result[j++] = max;
                if (deque.getFirst() == max) {
                    deque.removeFirst();
                    max = getMax(deque);
                } else {
                    deque.removeFirst();
                }
            }
        }
        return result;
    }

    private static int getMax(ArrayDeque<Integer> deque) {
        int max = Integer.MIN_VALUE;
        for (Integer integer : deque) {
            int data = (int) integer;
            max = Math.max(data, max);
        }
        return max;
    }

}
