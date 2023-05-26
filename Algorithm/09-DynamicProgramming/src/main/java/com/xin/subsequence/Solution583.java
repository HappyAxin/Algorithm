package com.xin.subsequence;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/delete-operation-for-two-strings/">583. 两个字符串的删除操作</a>
 * @Date 2023/05/26
 */
public class Solution583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 定义状态数组
        int[][] dp = new int[m + 1][n + 1];
        // dp[i][j]表示将word1的前i个字符转换为word2的前j个字符所需的最小步数

        // 初始化状态
        for (int i = 0; i <= m; i++) {
            // word2为空字符串，需要删除word1的字符
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            // word1为空字符串，需要删除word2的字符
            dp[0][j] = j;
        }

        // 动态规划求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 当前字符相等，不需要删除操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 当前字符不相等，选择删除操作的最小步数
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
