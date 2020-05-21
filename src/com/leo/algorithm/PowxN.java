package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/powx-n/
 */
public class PowxN {

    public static void main(String[] args) {
        double x = 2;
        int n = -2;
        PowxN.n = 0;
//        double result = myPowOffice(x, n);
        double result = myPow(x, n);
        System.out.println(result);
        System.out.println("n:" + PowxN.n);
    }

    public static double myPow(double x, int n) {
        if (n > 0) {
            return helper(x, n);
        } else {
            return 1 / helper(x, n);
        }
    }

    public static double helper(double x, int n) {
        PowxN.n++;
        if (n == 0) {
            return 1;
        }
        double y = helper(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }


    //=========================================================

    static int n = 0;

    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        n++;
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static double myPowOffice(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

}
