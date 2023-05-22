package com.xin.backpack;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/partition-equal-subset-sum/">416. 分割等和子集</a>
 * @Date 2023/05/22
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 如果数组元素和为奇数，无法分割成两个和相等的子集
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int n = nums.length;

        // 创建一个二维数组 dp，dp[i][j] 表示前 i 个数能否组成和为 j
        boolean[][] dp = new boolean[n + 1][target + 1];

        // 初始化边界条件
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // 逐步计算前 i 个数能否组成和为 j
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // 如果当前数 nums[i-1] 大于目标和 j，无法选择当前数
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 否则，可以选择当前数或不选择当前数
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][target];
    }
}
