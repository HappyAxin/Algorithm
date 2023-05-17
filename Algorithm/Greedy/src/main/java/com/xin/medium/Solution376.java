package com.xin.medium;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/wiggle-subsequence/">376. 摆动序列</a>
 * @Date 2023/05/16
 */
public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            // 如果数组长度小于2，则整个数组本身就是一个摆动子序列，直接返回数组长度
            return n;
        }
        // 记录上升摆动序列的长度
        int up = 1;
        // 记录下降摆动序列的长度
        int down = 1;

        for (int i = 1; i < n; i++) {
            // 如果当前数字大于前一个数字，说明形成了上升摆动，此时更新上升摆动序列的长度
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            // 如果当前数字小于前一个数字，说明形成了下降摆动，此时更新下降摆动序列的长度
            else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
            // 如果当前数字与前一个数字相等，则不改变上升和下降摆动序列的长度
        }

        // 返回上升和下降摆动序列长度的较大值
        return Math.max(up, down);
    }
}
