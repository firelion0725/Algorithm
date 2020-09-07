package com.leo.algorithm;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {5, 2, 5, 3, 5, 3, 1, 1, 3};
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

    public int[] topKFrequent3(int[] nums, int k) {
        //数据整体存入hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        //权重队列一次加入hashmap中的值
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.poll();
                queue.add(key);
            }
        }

        //装载最终答案
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }

}
