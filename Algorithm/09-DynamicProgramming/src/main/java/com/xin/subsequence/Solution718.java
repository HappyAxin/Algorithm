package com.xin.subsequence;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/maximum-length-of-repeated-subarray/">718. 最长重复子数组</a>
 * @Date 2023/05/26
 */
public class Solution718 {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        // dp[i][j]表示以nums1[i-1]和nums2[j-1]为结尾的最长公共子数组的长度
        int maxLength = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    // 当前元素相等，公共子数组长度加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }
}
