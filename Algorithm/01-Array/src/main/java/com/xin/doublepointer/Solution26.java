package com.xin.doublepointer;

/**
 * @author Hu·YX
 * @Description 删除有序数组中的重复项
 * @Link <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">26.删除有序数组中的重复项</a>
 * @Date 2023/01/10
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        if (nums.length == 0) {
            return 0;
        }
        for (int fast = 0; fast < nums.length - 1; fast++) {
            if (nums[fast] != nums[fast + 1]){
                nums[slow] = nums[fast + 1];
                slow++;
            }
        }
        return slow;
    }
}
