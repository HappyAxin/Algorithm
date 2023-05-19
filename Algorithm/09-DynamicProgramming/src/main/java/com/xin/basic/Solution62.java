package com.xin.basic;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/unique-paths/">62. 不同路径</a>
 * @Date 2023/05/19
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        // 创建一个二维数组来保存到达每个网格的路径数
        int[][] dp = new int[m][n];

        // 初始化边界条件：第一行和第一列的路径数都为1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 逐步计算到达每个网格的路径数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
