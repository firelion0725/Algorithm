package com.leo.algorithm;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {

    private int count = 0;
    private Deque<Integer> deque;
    private HashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        count = capacity;
        deque = new LinkedList<>();
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        } else {
            if (deque.contains(key)) {
                deque.remove(key);
                deque.addLast(key);
            }
            return map.get(key);
        }
    }

    public void put(int key, int value) {
        if (map.get(key) == null && map.size() < count) {
            map.put(key, value);
            deque.addLast(key);
        } else if (map.get(key) != null) {
            map.put(key, value);
            if (deque.contains(key)) {
                deque.remove(key);
                deque.addLast(key);
            }
        } else {
            int k = deque.poll();
            map.remove(k);
            map.put(key, value);
            deque.addLast(key);
        }
    }
}
