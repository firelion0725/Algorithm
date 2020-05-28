package com.leo.algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {

    }

    private List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = sortString(str);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }

        return new ArrayList<>(map.values());
    }

    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
