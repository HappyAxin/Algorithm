package com.xin.basic;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/unique-binary-search-trees/">96. 不同的二叉搜索树</a>
 * @Date 2023/05/19
 */
public class Solution96 {
    public int numTrees(int n) {
        // 创建一个数组来保存节点数为 i 的二叉搜索树的种数
        int[] dp = new int[n + 1];

        // 初始化边界条件
        dp[0] = 1;
        dp[1] = 1;

        // 逐步计算节点数为 i 的二叉搜索树的种数
        for (int i = 2; i <= n; i++) {
            // 计算节点数为 i 的二叉搜索树的种数
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
