package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/add-digits/
 */
public class AddDigits {

    public static void main(String[] args) {
        int num = 38;
        int result = addDigits(num);
        System.out.println("" + result);
    }

    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int result = 0;
        int temp = num;
        int digit = 0;
        while (temp > 0) {
            digit = temp % 10;
            result += digit;
            temp /= 10;
        }
        result = addDigits(result);
        return result;
    }

}
