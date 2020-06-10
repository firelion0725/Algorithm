package com.leo.algorithm;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        p.isPalindrome(3553);
    }

    public boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }

        int temp = x;
        int swapX = 0;
        while(temp !=0){
            int a = temp%10;
            temp /= 10;
            swapX = swapX*10+a;
        }

        return x == swapX;

    }
}
