package com.xin.basic;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/fibonacci-number/">509. 斐波那契数</a>
 * @Date 2023/05/19
 */
public class Solution509 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        // 创建一个数组来保存中间的结果
        int[] dp = new int[n + 1];

        // 初始化前两个数
        dp[0] = 0;
        dp[1] = 1;

        // 通过迭代计算后续的数
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 返回第 n 个斐波那契数
        return dp[n];
    }
}
