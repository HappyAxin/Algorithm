package com.xin.medium;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/wiggle-subsequence/">376. 摆动序列</a>
 * @Date 2023/05/16
 */
public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            // 如果数组长度小于2，直接返回数组长度
            return nums.length;
        }

        // 计算第一个差值
        int prevDiff = nums[1] - nums[0];
        // 如果第一个差值不为0，最长子序列长度至少为2，否则为1
        int maxLength = prevDiff != 0 ? 2 : 1;

        for (int i = 2; i < nums.length; i++) {
            // 计算当前差值
            int currDiff = nums[i] - nums[i - 1];

            // 如果当前差值和前一个差值正负号不同，则说明形成了摆动，最长子序列长度加一
            if ((currDiff > 0 && prevDiff <= 0) || (currDiff < 0 && prevDiff >= 0)) {
                maxLength++;
                // 更新前一个差值
                prevDiff = currDiff;
            }
        }

        return maxLength;
    }
}
