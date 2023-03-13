package com.xin.doublepointer;

/**
 * @author Hu·YX
 * @Description 有序数组的平方
 * @Link <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">977.有序数组的平方</a>
 * @Date 2023/01/10
 */
public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0, j = length - 1, insertIndex = length - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[insertIndex--] = nums[i] * nums[i++];
            } else {
                result[insertIndex--] = nums[j] * nums[j--];
            }
        }
        return result;
    }
}
