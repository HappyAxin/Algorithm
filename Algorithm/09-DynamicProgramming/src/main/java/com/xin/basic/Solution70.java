package com.xin.basic;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/climbing-stairs/">70. 爬楼梯</a>
 * @Date 2023/05/19
 */
public class Solution70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        // 创建一个数组来保存到达每个台阶的方法数
        int[] dp = new int[n + 1];
        // 爬1个台阶只有1种方法
        dp[1] = 1;
        // 爬2个台阶有2种方法
        dp[2] = 2;

        // 逐步计算爬楼梯的方法数
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
