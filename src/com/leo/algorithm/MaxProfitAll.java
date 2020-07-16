package com.leo.algorithm;

/**
 * 团灭股票问题全家
 * https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tuan-mie-gu-piao-wen-ti
 */
public class MaxProfitAll {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        MaxProfitAll m = new MaxProfitAll();
        m.maxProfit3(prices);
    }

    //伪代码 思路
    public int maxProfit0(int[] prices) {
        //总天数
        int i = prices.length;
        //可交易次数 无限制为最大
        int k = Integer.MAX_VALUE;
        //状态位 0：无股票 1:有股票
        int s = 2;
        int[][][] dp = new int[i][k][s];

        /**
         * 动态转移：
         * 解释：今天我没有持有股票，有两种可能：
         * 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
         * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
         */
        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);

        /**
         * 动态转移：
         * 解释：今天我持有着股票，有两种可能：
         * 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
         * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
         */
        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);

        /**
         * 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
         */
        dp[-1][k][0] = 0;

        /**
         * 解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
         */
        dp[-1][k][1] = Integer.MIN_VALUE;

        /**
         * 解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
         */
        dp[i][0][0] = 0;
        /**
         *  解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
         */
        dp[i][0][1] = Integer.MIN_VALUE;

        //状态转移方程：
        dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);

        return 0;
    }

    private int base(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n][k][2];
        dp[0][0][0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][0][0] - prices[i]);
            }
        }
        return dp[n - 1][k - 1][0];
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];

        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][2][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][max_k][0];
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
     */
    public int maxProfit4(int max_k, int[] prices) {
        if (max_k == 0) return 0;
        int n = prices.length;
        if (max_k > prices.length / 2) return profit(prices);
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            // base case
            dp[i][0][0] = 0;//至今为止没有交易，收益为0
            dp[i][0][1] = Integer.MIN_VALUE;//交易了0次，但持有股票，不符合规则
            for (int k = 1; k <= max_k; k++) {
                // base case
                if (i == 0) {
                    dp[i][k][0] = 0;//第一天买入k次，当天卖出k次,收入为0
                    dp[i][k][1] = -prices[i];//甭管第一天买多少次，反正最后少卖一次，持有了股票
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }

    private int profit(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 0; i < prices.length; i++) {
            tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
            tmp = dp_i_0;
        }
        return dp_i_0;
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     */
    public int maxProfit5(int max_k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], i > 1 ? dp[i - 2][0] - prices[i] : -prices[i]);
        }

        return dp[n - 1][0];
    }
}
