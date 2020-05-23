package com.leo.algorithm;

import java.util.HashMap;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat fish";
        boolean result = wordPattern(pattern, str);
        System.out.println(result);
    }

    public static boolean wordPattern(String pattern, String str) {
        char[] c1 = pattern.toCharArray();
        String[] s1 = str.split(" ");

        if(c1.length != s1.length){
            return false;
        }

        HashMap<String, Character> map = new HashMap<>();
        HashMap<Character, String> map2 = new HashMap<>();
        for (int i = 0; i < c1.length; i++) {
            if (map.containsKey(s1[i])) {
                if (map.get(s1[i]) != c1[i]) {
                    return false;
                }
            } else if (map2.containsKey(c1[i])) {
                if (!map2.get(c1[i]).equals(s1[i])) {
                    return false;
                }
            } else {
                map.put(s1[i], c1[i]);
                map2.put(c1[i], s1[i]);
            }
        }
        return true;
    }
}
