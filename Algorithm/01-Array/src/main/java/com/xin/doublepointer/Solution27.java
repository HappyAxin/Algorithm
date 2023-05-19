package com.xin.doublepointer;

/**
 * @author Hu·YX
 * @Description 移除元素
 * @link <a href="https://leetcode.cn/problems/remove-element/">27.移除元素</a>
 * @Date 2023/01/09
 */
public class Solution27 {
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= 0 && nums[right] == val) {
            right--;
        }
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right--];
            }
            left++;
            while (right >= 0 && nums[right] == val) {
                right--;
            }
        }
        return left;
    }
}
