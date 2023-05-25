package com.xin.stock;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/">123. 买卖股票的最佳时机 III</a>
 * @Date 2023/05/25
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            // 如果数组长度小于2，无法完成交易，返回0
            return 0;
        }

        int[][] dp = new int[n][5];
        // dp[i][j] 表示第i天进行第j次交易时的最大利润

        // 初始化第一天的交易情况
        dp[0][1] = - prices[0];
        dp[0][3] = - prices[0];

        for (int i = 1; i < n; i++) {
            // 未进行任何交易
            dp[i][0] = dp[i - 1][0];
            // 第一次买入股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 第一次卖出股票
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            // 第二次买入股票
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            // 第二次卖出股票
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        // 返回最后一天完成两次交易的最大利润
        return dp[n - 1][4];
    }
}
