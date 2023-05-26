package com.xin.subsequence;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/palindromic-substrings/">647. 回文子串</a>
 * @Date 2023/05/26
 */
public class Solution647 {
    public int countSubstrings(String s) {
        int n = s.length();
        // dp[i][j]表示s从索引i到索引j的子串是否为回文串
        boolean[][] dp = new boolean[n][n];

        // 统计回文子串的数目
        int count = 0;

        // 动态规划求解
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                // 判断当前子串是否为回文串
                if (s.charAt(start) == s.charAt(end)) {
                    // 当子串长度为1或2时，只需判断首尾字符是否相等即可
                    if (len == 1 || len == 2 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
