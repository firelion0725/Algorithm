package com.leo.algorithm;

public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }
        //防止边界问题
        long x = n;
        x = x & (x - 1);
        return x == 0;
    }

}
