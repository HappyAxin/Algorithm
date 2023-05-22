package com.xin.backpack;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/combination-sum-iv/">377. 组合总和IV</a>
 * @Date 2023/05/22
 */
public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
