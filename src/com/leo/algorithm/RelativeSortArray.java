package com.leo.algorithm;

import java.util.*;

public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = {2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
        int[] arr2 = {2, 42, 38, 0, 43, 21};
        RelativeSortArray r = new RelativeSortArray();
        r.relativeSortArray(arr1, arr2);
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int value : arr1) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        int index = 0;
        for (int data : arr2) {
            int count = map.get(data);
            while (count > 0) {
                res[index++] = data;
                count--;
                map.remove(data);
            }
        }

        if (map.size() > 0) {
            int[] tempArr = new int[map.size()];
            int i = 0;
            for (int v : map.keySet()) {
                tempArr[i++] = v;
            }
            Arrays.sort(tempArr);

            for (int v : tempArr) {
                int count = map.get(v);
                while (count > 0) {
                    res[index++] = v;
                    count--;
                }
            }
        }

        return res;
    }


}
