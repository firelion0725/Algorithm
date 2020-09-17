package com.leo.algorithm;

import java.util.Arrays;

/**
 * 百度面试原题
 * https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class CompareVersion {

    public static void main(String[] args) {
        String version1 = "7.5.2.6";
        String version2 = "7.5.3";
        CompareVersion compareVersion = new CompareVersion();
        int res = compareVersion.compareVersion(version1, version2);
        System.out.println(res);
    }

    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");

        int diff = Math.abs(strs1.length - strs2.length);

        if (diff != 0) {
            if (strs1.length > strs2.length) {
                int size = strs2.length;
                strs2 = Arrays.copyOf(strs2, size + diff);
                for (int i = 0; i < diff; i++) {
                    strs2[size + i] = "0";
                }
            } else {
                int size = strs1.length;
                strs1 = Arrays.copyOf(strs1, size + diff);
                for (int i = 0; i < diff; i++) {
                    strs1[size + i] = "0";
                }
            }
        }

        for (int i = 0; i < strs1.length; i++) {
            int v1 = stringToInt(strs1[i]);
            int v2 = stringToInt(strs2[i]);
            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }
        }

        return 0;
    }

    private int stringToInt(String str) {
        return Integer.parseInt(str);
    }
}
