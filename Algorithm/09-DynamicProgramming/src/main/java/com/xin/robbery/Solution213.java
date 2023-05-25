package com.xin.robbery;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/house-robber-ii/">213. 打家劫舍 II</a>
 * @Date 2023/05/25
 */
public class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }

        // 在第一种情况下，偷窃第1间房屋到第n-1间房屋（不偷窃最后一间房屋）
        int maxAmount1 = robRange(nums, 0, n - 2);

        // 在第二种情况下，偷窃第2间房屋到第n间房屋（不偷窃第一间房屋）
        int maxAmount2 = robRange(nums, 1, n - 1);

        // 返回两种情况下的最大金额
        return Math.max(maxAmount1, maxAmount2);
    }

    /**
     * 计算指定范围内房屋能够偷窃到的最大金额
     *
     * @param nums  数组
     * @param start 范围开始
     * @param end   范围结束
     * @return int
     */
    private static int robRange(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 1) {
            return nums[start];
        }

        int[] dp = new int[n];
        dp[0] = nums[start];
        // 前两个房屋中选择金额较大的进行偷窃
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            // 在前 i-1 个房屋中选择最大的金额，或者当前房屋金额加上前 i-2 个房屋中的最大金额
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[n - 1];
    }
}
