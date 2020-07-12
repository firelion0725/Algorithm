package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        int num = 808201;
        System.out.println(Math.sqrt(num));
        IsPerfectSquare i = new IsPerfectSquare();
        i.isPerfectSquare2(num);
    }

    public boolean isPerfectSquare2(int num) {
        if (num == 1) {
            return true;
        }
        long start = 2;
        long end = num / 2;

        while (start <= end) {
            long mid = (start + end) / 2;
            long guess = mid * mid;
            if (guess == num) {
                return true;
            }
            if (guess > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

}
