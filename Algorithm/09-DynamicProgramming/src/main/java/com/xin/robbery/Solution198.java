package com.xin.robbery;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/house-robber/">198. 打家劫舍</a>
 * @Date 2023/05/25
 */
public class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }

        // 创建一个数组存储偷窃金额的动态规划结果
        int[] dp = new int[n];
        // 第一个房间智能偷窃该房间的金额
        dp[0] = nums[0];
        // 前两个房屋中选择金额较大的进行偷窃
        dp[1] = Math.max(nums[0], nums[1]);

        // 动态规划过程，从第三个房屋开始计算最大偷窃金额
        for (int i = 2; i < n; i++) {
            // 在前 i-1 个房屋中选择最大的金额，或者当前房屋金额加上前 i-2 个房屋中的最大金额
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
