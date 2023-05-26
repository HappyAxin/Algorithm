package com.xin.subsequence;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/longest-palindromic-subsequence/">516. 最长回文子序列</a>
 * @Date 2023/05/26
 */
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        // 定义状态数组
        int[][] dp = new int[n][n];
        // dp[i][j]表示字符串s从索引i到索引j的最长回文子序列长度

        // 初始化状态
        for (int i = 0; i < n; i++) {
            // 单个字符是回文子序列，长度为1
            dp[i][i] = 1;
        }

        // 动态规划求解
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    // 首尾字符相等，长度加2
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 首尾字符不相等，取较长的子序列长度
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
