package com.leo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 经典的滑动窗口问题 的基础题 必会！
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class FindContinuousSequence {

    //传统的穷举法
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();


        for (int i = 1; i <= target / 2 + 1; i++) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int j = i; j <= target / 2 + 1; j++) {
                list.add(j);
                sum += j;
                if (sum == target) {
                    res.add((listToArray(list)));
                    break;
                } else if (sum > target) {
                    break;
                }
            }
        }

        return listToArray2(res);
    }

    private int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int[][] listToArray2(List<int[]> list) {
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    //====================滑动窗口 本质为双指针===============================

    public static void main(String[] args) {
        FindContinuousSequence f = new FindContinuousSequence();
        f.findContinuousSequenceOffice(9);
    }

    public int[][] findContinuousSequenceOffice(int target) {
        List<int[]> res = new ArrayList<>();

        int left = 1;
        int right = 2;
        int sum = 3;
        while (left <= target / 2) {
            if (sum == target) {
                //进入结果集
                res.add(getArray(left, right));
                sum -= left;
                left++;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        return listToArray2(res);
    }

    private int[] getArray(int left, int right) {
        int[] res = new int[right - left + 1];
        for (int i = 0; i < right - left + 1; i++) {
            res[i] = left + i;
        }
        return res;
    }

}
