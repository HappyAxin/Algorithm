package com.xin.stock;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/">309. 最佳买卖股票时机含冷冻期</a>
 * @Date 2023/05/25
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        // 检查prices的长度，如果小于等于1，则直接返回0
        if (prices.length <= 1) {
            return 0;
        }

        // 初始化三种状态的动态规划表
        // 持有股票
        int[] hold = new int[prices.length];
        // 不持有股票，处于冷冻期
        int[] freeze = new int[prices.length];
        // 不持有股票，不处于冷冻期
        int[] unhold = new int[prices.length];

        // 初始化第一天的状态
        hold[0] = - prices[0];
        freeze[0] = 0;
        unhold[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 更新持有股票状态的最大利润
            hold[i] = Math.max(hold[i - 1], unhold[i - 1] - prices[i]);

            // 更新处于冷冻期状态的最大利润
            freeze[i] = hold[i - 1] + prices[i];

            // 更新不处于冷冻期状态的最大利润
            unhold[i] = Math.max(unhold[i - 1], freeze[i - 1]);
        }

        // 返回最后一天可能的最大利润
        return Math.max(freeze[prices.length - 1], unhold[prices.length - 1]);
    }
}
