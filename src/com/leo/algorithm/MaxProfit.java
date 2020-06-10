package com.leo.algorithm;

public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {3,4,2,3,19,3};
        MaxProfit m = new MaxProfit();
        m.maxProfitOffice(prices);
    }

    /**
     * 动态规划
     */
    public int maxProfit(int[] prices) {

        if(prices.length<2){
            return 0;
        }

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash , preHold + prices[i]);
            hold = Math.max(preHold, preCash-prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }

    public int maxProfitOffice(int[] prices){
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max+=Math.max(prices[i]-prices[i-1],0);
        }
        return max;
    }
}
