package com.xin.medium.stock;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">122. 买卖股票的最佳时机 II</a>
 * @Date 2023/05/17
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        // 记录最大利润
        int maxProfit = 0;

        // 遍历股票价格数组
        for (int i = 1; i < prices.length; i++) {
            // 获取每天的正利润
            maxProfit += Math.max(prices[i] - prices[i - 1], 0);
        }

        return maxProfit;
    }
}
