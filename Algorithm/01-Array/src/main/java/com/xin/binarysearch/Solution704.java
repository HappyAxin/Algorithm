package com.xin.binarysearch;

/**
 * @author Hu·YX
 * @Description 二分查找法
 * @Link <a href="https://leetcode.cn/problems/binary-search/">704.二分查找法</a>
 * @Date 2023/01/09
 */
public class Solution704 {
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = Math.addExact(left, right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
