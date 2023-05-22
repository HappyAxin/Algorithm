package com.xin.backpack;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/last-stone-weight-ii/">1049. 最后一块石头的重量 II</a>
 * @Date 2023/05/22
 */
public class Solution1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int n = stones.length;
        int target = sum / 2;

        // 创建一个一维数组 dp，dp[j] 表示是否能够得到重量为 j 的石头
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // 逐步计算能够得到重量为 j 的石头
        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] |= dp[j - stone];
            }
        }

        // 找到最大的 j，使得 dp[j] 为 true
        int result = 0;
        for (int j = target; j >= 0; j--) {
            if (dp[j]) {
                result = sum - 2 * j;
                break;
            }
        }

        return result;
    }
}
