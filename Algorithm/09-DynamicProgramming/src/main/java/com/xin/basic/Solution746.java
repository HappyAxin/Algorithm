package com.xin.basic;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/">746. 使用最小花费爬楼梯</a>
 * @Date 2023/05/19
 */
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // 创建一个数组来保存达到每个台阶的最低花费
        int[] dp = new int[n];

        // 初始状态：到达第一个台阶和第二个台阶的最低花费分别为cost[0]和cost[1]
        dp[0] = cost[0];
        dp[1] = cost[1];

        // 逐步计算达到每个台阶的最低花费
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // 最后一步可以选择从倒数第一个台阶或倒数第二个台阶跨到顶部，取两者最小值
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
