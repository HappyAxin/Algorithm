package com.xin.subsequence;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/maximum-subarray/">53. 最大子数组和</a>
 * @Date 2023/05/26
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        // 定义状态数组
        int[] dp = new int[n];
        // dp[i]表示以第i个元素结尾的最大子数组和

        // 初始化状态
        // 第一个元素自身是最大子数组和
        dp[0] = nums[0];

        // 最大子数组和
        int maxSum = dp[0];
        for (int i = 1; i < n; i++) {
            // 包含当前元素或重新开始一个新的子数组
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
