package com.leo.algorithm;

public class PerfectSquare {

    public static void main(String[] args) {
        PerfectSquare perfectSquare = new PerfectSquare();
        perfectSquare.isPerfectSquare(808201);
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        long left = 2;
        long right = num / 2;

        while (left <= right) {
            long mid = (left + right) / 2;

            long guessNum = mid * mid;
            if (guessNum == num) {
                return true;
            }
            if (guessNum > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public boolean isPerfectSquareOffice(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }
}
