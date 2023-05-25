package com.xin.stock;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/">188. 买卖股票的最佳时机 IV</a>
 * @Date 2023/05/25
 */
public class Solution188 {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1 || k <= 0) {
            return 0;
        }

        // 当k大于数组长度的一半时，相当于可以进行无限次交易，可以直接使用贪心算法解决
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // 定义状态数组
        int[][][] dp = new int[n][k + 1][2];
        // dp[i][j][0]表示在第i天，进行了j次交易，手上没有持有股票时的最大利润
        // dp[i][j][1]表示在第i天，进行了j次交易，手上持有股票时的最大利润

        // 初始化状态
        for (int j = 0; j <= k; j++) {
            // 第一天没有持有股票，利润为0
            dp[0][j][0] = 0;
            // 第一天持有股票，利润为负的买入价格
            dp[0][j][1] = - prices[0];
        }

        // 动态规划求解
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                // 第i天没有持有股票的情况：
                // 1. 保持前一天没有持有股票的状态
                // 2. 前一天持有股票，今天卖出
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);

                // 第i天持有股票的情况：
                // 1. 保持前一天持有股票的状态
                // 2. 前一天没有持有股票，今天买入
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        // 返回最大利润
        return dp[n - 1][k][0];
    }
}
