package com.xin.doublepointer;

/**
 * @author Hu·YX
 * @Description 移动零
 * @Link <a href="https://leetcode.cn/problems/move-zeroes/">283.移动零</a>
 * @Date 2023/01/10
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int low = 0;
        for (int high = 0; high < nums.length; high++) {
            if (nums[high] != 0) {
                nums[low] = nums[high];
                low++;
            }
        }
        for (int i = low; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
