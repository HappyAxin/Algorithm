package com.xin.subsequence;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/uncrossed-lines/">1035. 不相交的线</a>
 * @Date 2023/05/26
 */
public class Solution1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // 定义状态数组
        int[][] dp = new int[m + 1][n + 1];
        // dp[i][j]表示nums1的前i个数字与nums2的前j个数字的最大连线数
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    // 当前数字相等，最大连线数加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 当前数字不相等，取前一个状态中的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
