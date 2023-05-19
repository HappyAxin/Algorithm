package com.xin.medium.stock;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">714. 买卖股票的最佳时机含手续费</a>
 * @Date 2023/05/18
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // 当前手中的现金
        int cash = 0;
        // 当前持有股票的价值（负值表示花费的现金）
        int hold = - prices[0];

        for (int i = 1; i < n; i++) {
            // 如果卖出股票能获得更高的价值，则卖出股票
            cash = Math.max(cash, hold + prices[i] - fee);
            // 如果买入股票能获得更高的价值，则买入股票
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}
