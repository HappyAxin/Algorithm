package com.xin.subsequence;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/distinct-subsequences/">115. 不同的子序列</a>
 * @Date 2023/05/26
 */
public class Solution115 {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // 定义状态数组
        long[][] dp = new long[m + 1][n + 1];
        // dp[i][j]表示s的前i个字符中t的前j个字符出现的次数
        for (int i = 0; i <= m; i++) {
            // t为空字符串，是任何字符串的子序列，所以出现次数为1
            dp[i][0] = 1;
        }

        // 动态规划求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return (int) dp[m][n];
    }
}
