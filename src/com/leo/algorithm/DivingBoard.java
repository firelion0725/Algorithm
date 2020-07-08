package com.leo.algorithm;

/**
 * https://leetcode-cn.com/problems/diving-board-lcci/
 */
public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[k];
        }

        if (shorter == longer) {
            int[] res = new int[1];
            res[0] = k;
            return res;
        }

        int[] res = new int[k + 1];

        for (int i = 0; i < res.length; i++) {
            res[i] = (longer * i) + (shorter * (k - i));
        }

        return res;
    }


}
