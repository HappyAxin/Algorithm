package com.xin.stock;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">714. 买卖股票的最佳时机含手续费</a>
 * @Date 2023/05/25
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        // 检查prices的长度，如果小于等于1，则直接返回0
        if (prices.length <= 1) {
            return 0;
        }

        // 初始化两种状态的动态规划表
        // 持有股票
        int[] hold = new int[prices.length];
        // 不持有股票
        int[] unhold = new int[prices.length];

        // 初始化第一天的状态
        hold[0] = - prices[0];
        unhold[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 更新持有股票状态的最大利润
            hold[i] = Math.max(hold[i - 1], unhold[i - 1] - prices[i]);

            // 更新不持有股票状态的最大利润，这里需要考虑手续费
            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i] - fee);
        }

        // 返回最后一天可能的最大利润，这个利润应该是不持有股票状态的利润
        return unhold[prices.length - 1];
    }
}
