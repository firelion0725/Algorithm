package com.leo.algorithm;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        int amount = 11;
        CoinChange c = new CoinChange();
        c.coinChange(nums, amount);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }

        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, count);
            if (res >= 0) {
                min = Math.min(min, res + 1);
            }
        }

        count[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[amount - 1];
    }

}
