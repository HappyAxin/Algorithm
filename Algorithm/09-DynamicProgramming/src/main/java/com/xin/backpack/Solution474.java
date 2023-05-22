package com.xin.backpack;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/ones-and-zeroes/">474. 一和零</a>
 * @Date 2023/05/22
 */
public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zeros = 0;
            int ones = 0;

            // 统计当前字符串中 0 和 1 的个数
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else if (c == '1') {
                    ones++;
                }
            }

            // 更新动态规划数组
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    // 选择当前字符串时，更新最大子集长度
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
