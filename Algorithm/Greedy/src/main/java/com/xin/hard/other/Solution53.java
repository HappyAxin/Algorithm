package com.xin.hard.other;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/maximum-subarray/">53. 最大子数组合</a>
 * @Date 2023/05/17
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        // 记录最大子数组和
        int maxSum = nums[0];
        // 记录当前子数组和
        int currSum = nums[0];

        // 从数组的第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 对于当前元素，有两种选择：
            // 1. 将当前元素加入到当前子数组中
            // 2. 以当前元素作为新的起点开始一个新的子数组

            // 如果将当前元素加入到当前子数组后，当前子数组和变得更小了，那么就以当前元素作为新的起点开始一个新的子数组
            currSum = Math.max(nums[i], currSum + nums[i]);
            // 更新最大子数组和
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
