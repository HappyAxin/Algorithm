package com.xin.slidingwindow;

/**
 * @author Hu·YX
 * @Description 长度最小的子数组
 * @Link <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">209.长度最小的子数组</a>
 * @Date 2023/01/10
 */
public class Solution209 {
    /**
     * 滑动窗口
     * @param target    目标值
     * @param nums      目标数组
     * @return int
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
