package com.xin.binarysearch;

/**
 * @author Hu·YX
 * @Description 搜索插入位置
 * @Link <a href="https://leetcode.cn/problems/search-insert-position/">35.搜索插入位置</a>
 * @Date 2023/01/09
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            // 右移一位，相当于该数除以2
            int middle = low + ((high - low) >> 1);
            if (nums[middle] < target) {
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle;
            } else {
                return middle;
            }
        }
        return high;
    }
}
