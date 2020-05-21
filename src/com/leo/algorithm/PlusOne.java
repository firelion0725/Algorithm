package com.leo.algorithm;

import com.leo.algorithm.utils.Utils;


/**
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9,};
        int[] result = plusOne(digits);
        Utils.showResult(result);
    }

    public static int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0) {
            digits[index]++;
            digits[index] %= 10;
            if (digits[index] != 0) {
                return digits;
            }
            index--;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

}
