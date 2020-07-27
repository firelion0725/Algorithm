package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class IsStringSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();

        int index = 0;
        for (char c : ts) {
            if (c == ss[index]) {
                index++;
                if (index == ss.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
