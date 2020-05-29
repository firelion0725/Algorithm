package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 */
public class NumberOfSegmentsInString {

    public static void main(String[] args) {
        String str = ", , , ,        a, eaefa";
        int result = countSegments(str);
        System.out.println(result);
    }

    public static int countSegments(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                start = i;
            } else {
                if (start != -1) {
                    count++;
                    start = -1;
                }
            }
        }
        if (s.charAt(s.length() - 1) != ' ') {
            count++;
        }
        return count;
    }
}
