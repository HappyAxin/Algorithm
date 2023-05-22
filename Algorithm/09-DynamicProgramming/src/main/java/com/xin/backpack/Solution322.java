package com.xin.backpack;

import java.util.Arrays;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/coin-change/">322. 零钱兑换</a>
 * @Date 2023/05/22
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? - 1 : dp[amount];
    }
}
