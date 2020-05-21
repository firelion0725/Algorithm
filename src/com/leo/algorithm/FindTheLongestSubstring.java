package com.leo.algorithm;

import com.leo.algorithm.utils.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheLongestSubstring {

    private static final char A = 'a';
    private static final char E = 'e';
    private static final char I = 'i';
    private static final char O = 'o';
    private static final char U = 'u';

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        int result = findTheLongestSubstring(s);
        Utils.showResult("" + result);
    }

    public static int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        int index = 0;
        int count = 0;
        map.put(count, chars.length);
        while (index < chars.length) {
            char c = chars[index];
            if (isA(c)) {
                count++;
                if (count % 2 == 0) {
                    map.put(count, index);
                }
            }
            index++;
        }

        int key = count % 2 == 0 ? count : count - 1;

        if (map.get(key) != null) {
            return map.get(key);
        } else {
            return 0;
        }
    }

    private static boolean isA(char c) {
        return c == A || c == E || c == I || c == O || c == U;
    }


    //====================================================

    public int findTheLongestSubstringOffice(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }


}
