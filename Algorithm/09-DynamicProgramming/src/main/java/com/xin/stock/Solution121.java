package com.xin.stock;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">121. 买卖股票的最佳时机</a>
 * @Date 2023/05/25
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            // 如果数组长度小于2，则无法进行买卖交易，最大利润为0
            return 0;
        }

        // 创建动态规划数组，dp[i]表示第i天的最大利润
        int[] dp = new int[n];
        // 初始化最低价格为第一天的价格
        int minPrice = prices[0];

        for (int i = 1; i < n; i++) {
            // 更新最低价格
            minPrice = Math.min(minPrice, prices[i]);
            // 当天的最大利润等于前一天的最大利润和当前价格与最低价格之差的较大值
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }

        // 返回最后一天的最大利润
        return dp[n - 1];
    }
}
