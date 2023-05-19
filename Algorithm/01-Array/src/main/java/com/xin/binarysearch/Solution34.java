package com.xin.binarysearch;

import java.util.Arrays;

/**
 * @author Hu·YX
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * @Link <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">34.在排序数组中查找元素的第一个和最后一个位置</a>
 * @Date 2023/01/09
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }
        int left = index, right = index;
        while (left - 1 >= 0 && nums[left - 1] == nums[index]) {
            left--;
        }
        while (right + 1 < nums.length && nums[right + 1] == nums[index]) {
            right++;
        }
        return new int[]{left, right};
    }
}
