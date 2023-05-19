package com.xin.hard.interval;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/jump-game-ii/">45. 跳跃游戏 II</a>
 * @Date 2023/05/17
 */
public class Solution45 {
    public int jump(int[] nums) {
        // 记录跳跃次数
        int jumps = 0;
        // 当前能够到达的最远位置
        int currEnd = 0;
        // 当前能够到达的最远距离
        int currFarthest = 0;

        // 遍历数组
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新当前能够到达的最远距离
            currFarthest = Math.max(currFarthest, i + nums[i]);

            // 如果当前位置达到了当前能够到达的最远位置
            if (i == currEnd) {
                // 进行一次跳跃
                jumps++;
                // 更新当前能够到达的最远位置
                currEnd = currFarthest;
            }
        }

        return jumps;
    }
}
