package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/decode-string/solution/zi-fu-chuan-jie-ma-by-leetcode-solution/
 */
public class DecodeString {

    private static final int MU_LEFT = 3;
    private static final int MU_RIGHT = 4;
    private static final int WORD = 1;
    private static final int NUM = 2;

    public static void main(String[] args) {
        String s = "10[a]2[bc]";
        String result = decodeString(s);
        System.out.println(result);
    }

    public static String decodeString(String s) {
        return helper(s);
    }

    private static String helper(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int times = 0;
        int muCount = 0;
        int start = 0;
        int end = 0;
        int countStart = -1;
        int countEnd = -1;
        for (int i = 0; i < str.length(); i++) {
            int type = getCharType(str.charAt(i));
            switch (type) {
                case MU_LEFT:
                    muCount++;
                    if (muCount == 1) {
                        start = i;
                    }
                    break;
                case MU_RIGHT:
                    muCount--;
                    if (muCount == 0) {
                        end = i;
                        String t;
                        if (countEnd == -1) {
                            t = str.substring(countStart, countStart + 1);
                        } else {
                            t = str.substring(countStart, countEnd + 1);
                        }

                        countStart = -1;
                        countEnd = -1;
                        times = t.length() > 0 ? Integer.valueOf(t) : 0;
                        for (int j = 0; j < times; j++) {
                            String s = str.substring(start + 1, end);
                            stringBuffer.append(helper(s));
                        }
                    }
                    break;
                case WORD:
                    if (muCount == 0) {
                        stringBuffer.append(str.charAt(i));
                    }
                    break;
                case NUM:
                    if (muCount == 0) {
                        if (countStart == -1) {
                            countStart = i;
                        } else {
                            countEnd = i;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return stringBuffer.toString();
    }

    private static int getCharType(Character c) {
        if (c == '[') {
            return MU_LEFT;
        }
        if (c == ']') {
            return MU_RIGHT;
        }
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
                || c == '5' || c == '6' || c == '7' || c == '8' || c == '9'
        ) {
            return NUM;
        } else {
            return WORD;
        }
    }
}
