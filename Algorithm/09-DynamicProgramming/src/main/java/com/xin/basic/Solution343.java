package com.xin.basic;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/integer-break/">343. 整数拆分</a>
 * @Date 2023/05/19
 */
public class Solution343 {
    public int integerBreak(int n) {
        // 创建一个数组来保存拆分整数 i 可获得的最大乘积
        int[] dp = new int[n + 1];

        // 初始化边界条件
        dp[1] = 1;

        // 逐步计算拆分整数 i 可获得的最大乘积
        for (int i = 2; i <= n; i++) {
            // 计算拆分整数 i 的最大乘积
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
}
