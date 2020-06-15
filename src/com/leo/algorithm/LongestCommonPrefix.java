package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"aa", "a"};
        LongestCommonPrefix l = new LongestCommonPrefix();
        l.longestCommonPrefix(strs);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = strs[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length()-1 < i) {
                    return stringBuilder.toString();
                }
                if (strs[j].charAt(i) != c) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
