package com.xin.subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/is-subsequence/">392. 判断子序列</a>
 * @Date 2023/05/26
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        // 定义状态数组
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[i][j]表示s的前i个字符是否为t的前j个字符的子序列
        for (int i = 0; i <= n; i++) {
            // 空字符串是任何字符串的子序列
            dp[0][i] = true;
        }

        // 动态规划求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 当前字符匹配，取前一个状态
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 当前字符不匹配，取当前状态的前一个状态
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
