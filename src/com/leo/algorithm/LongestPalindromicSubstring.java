package com.leo.algorithm;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "ac";
//        boolean result = checkPalindromic(s);
//        System.out.println(result);
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if(chars.length<2){
            return s;
        }
        int maxLength = 0;
        int maxStart = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = chars.length - 1; j >= i; j--) {
                if (chars[i] == chars[j] && isCheck(chars, i, j)) {
                    int length = j - i + 1;
                    if (maxLength < length) {
                        maxLength = length;
                        maxStart = i;
                    }
                }
            }
        }
        if (maxLength > 0) {
            char[] resultChar = new char[maxLength];
            System.arraycopy(chars, maxStart, resultChar, 0, maxLength);
            return new String(resultChar);
        } else {
            return "";
        }
    }

    private static boolean isCheck(char[] chars, int start, int end) {
        while (start <= end) {

            if (chars[start] != chars[end]) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    private static boolean checkPalindromic(String s) {
        return checkPalindromic(s.toCharArray());
    }

    private static boolean checkPalindromic(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(chars[start])) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[end])) {
                end--;
                continue;
            }

            if (!isEqual(chars[start], chars[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    private static boolean isEqual(char c1, char c2) {
        if (c1 == c2) {
            return true;
        } else if (Character.isLetter(c1) && Character.isLetter(c2)) {
            if (c1 == c2 - 32 || c1 == c2 + 32) {
                return true;
            }
        }
        return false;
    }

}
