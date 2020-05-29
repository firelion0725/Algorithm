package com.leo.algorithm;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {5,2,5,3,5,3,1,1,3};
        int[] result = topKFrequentOffice(nums, 2);
        System.out.println(result);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }

    public static int[] topKFrequentOffice(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else {
                if (map.get(key) > map.get(pq.peek())) {
                    pq.remove();
                    pq.add(key);
                }
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }
        return result;
    }

}
