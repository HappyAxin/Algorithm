package com.xin.subsequence;

import java.util.Arrays;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">300. 最长递增子序列</a>
 * @Date 2023/05/26
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;

        for(int i = 1; i < dp.length; i++){
            int maxval = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
