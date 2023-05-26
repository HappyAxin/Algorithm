package com.xin.subsequence;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/longest-continuous-increasing-subsequence/">674. 最长连续递增序列</a>
 * @Date 2023/05/26
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxLen = 1;
        int curLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = 1;
            }
        }

        return Math.max(maxLen, curLen);
    }
}
