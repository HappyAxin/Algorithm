package com.xin.basic;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/unique-paths-ii/">63. 不同路径 II</a>
 * @Date 2023/05/19
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 创建一个二维数组来保存到达每个网格的路径数
        int[][] dp = new int[m][n];

        // 处理起始位置和障碍物情况
        if (obstacleGrid[0][0] == 1) {
            // 起始位置有障碍物，无法到达终点
            return 0;
        }
        // 起始位置为1，表示可达
        dp[0][0] = 1;

        // 处理第一行和第一列的路径数，遇到障碍物后面的路径数均为0
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // 逐步计算到达每个网格的路径数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // 障碍物位置，路径数为0
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
