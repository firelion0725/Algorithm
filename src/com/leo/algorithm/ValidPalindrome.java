package com.leo.algorithm;

public class ValidPalindrome {

    public static void main(String[] args) {

        String s = "ngzodrdohhqilovouwqrbpgqvlplsnfzueemmjtqnizodigfzeuuezfgidozinqtjmmeeuzfnslpvqgpbrqwuovoliqhhodirdozgn";
        boolean result = isPalindromeSecond(s);
        System.out.println(result);

    }

    /**
     * https://leetcode-cn.com/problems/valid-palindrome/
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        //TODO 代做
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/valid-palindrome-ii/
     *
     * @param s
     * @return
     */
    public static boolean isPalindromeSecond(String s) {
        char[] chars = s.toCharArray();
        return check(chars);
    }

    private static boolean check(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        boolean isDelete = false;
        while (start < end) {
            char c1 = chars[start];
            char c2 = chars[end];

            if (c1 == c2) {
                start++;
                end--;
            } else {
                boolean isDeleteStart = chars[start + 1] == c2;
                boolean isDeleteEnd = c1 == chars[end - 1];

                if (isDeleteStart && !isDeleteEnd) {
                    start++;
                    if (isDelete) {
                        return false;
                    } else {
                        isDelete = true;
                    }

                } else if (!isDeleteStart && isDeleteEnd) {
                    end--;
                    if (isDelete) {
                        return false;
                    } else {
                        isDelete = true;
                    }
                } else if (isDeleteStart && isDeleteEnd) {
                    if(isDelete){
                        return false;
                    }
                    boolean flag1 = true;
                    boolean flag2 = true;
                    for (int i = start, j = end - 1; i < j; i++, j--) {
                        char c3 = chars[i];
                        char c4 = chars[j];
                        if (c3 != c4) {
                            flag1 = false;
                            break;
                        }
                    }

                    for (int i = start + 1, j = end; i < j; i++, j--) {
                        char c3 = chars[i];
                        char c4 = chars[j];
                        if (c3 != c4) {
                            flag2 = false;
                            break;
                        }
                    }

                    return flag1 || flag2;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
