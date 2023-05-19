package com.xin.hard.interval;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/jump-game/">55. 跳跃游戏</a>
 * @Date 2023/05/17
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        // 记录当前能够到达的最远位置
        int maxReach = 0;

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置超过了当前能够到达的最远位置，说明无法到达最后一个下标
            if (i > maxReach) {
                return false;
            }
            // 更新当前能够到达的最远位置
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        // 如果最后能够到达的位置大于等于最后一个下标，说明可以到达最后一个下标
        return maxReach >= nums.length - 1;
    }
}
