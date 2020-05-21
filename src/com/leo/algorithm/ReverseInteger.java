package com.leo.algorithm;

import com.leo.algorithm.utils.Utils;

import java.util.LinkedList;
import java.util.List;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = 123456;
        int result = reverseOffice(x);
        Utils.showResult("" + result);
    }

    /**
     * 最蠢的解法 是个人就会
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int flag = 0;
        flag = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        char[] chars2 = changeChars(chars);
        try {
            return Integer.parseInt(String.valueOf(chars2)) * flag;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static char[] changeChars(char[] chars) {
        char temp;
        for (int i = 0; i < chars.length / 2; i++) {
            temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return chars;
    }

    int max = 2_147_483_647;
    int min = -2_147_483_648;






    //=====================官方标答=================================

    static int reverseOffice(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


}
