package com.leo.algorithm;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

    public static void main(String[] args) {

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int num : candies) {
            max = Math.max(max, num);
        }

        for (int num : candies) {
            result.add(max - num <= extraCandies);
        }
        return result;
    }
}
