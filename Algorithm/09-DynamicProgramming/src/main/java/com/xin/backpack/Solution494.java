package com.xin.backpack;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/target-sum/">494. 目标和</a>
 * @Date 2023/05/22
 */
public class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 如果总和小于目标值，或者总和与目标值之差为奇数，无法得到目标值
        if (sum < target || (sum - target) % 2 != 0) {
            return 0;
        }

        int newTarget = (sum - target) / 2;

        // 创建一个一维数组 dp，dp[i] 表示凑成和为 i 的方式数
        int[] dp = new int[newTarget + 1];
        dp[0] = 1;

        // 逐步计算凑成和为 i 的方式数
        for (int num : nums) {
            for (int j = newTarget; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[newTarget];
    }
}
