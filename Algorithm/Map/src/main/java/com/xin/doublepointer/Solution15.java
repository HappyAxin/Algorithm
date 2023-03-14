package com.xin.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hu·YX
 * @Description 15. 三数之和
 * @Link <a href="https://leetcode.cn/problems/3sum/">15. 三数之和</a>
 * @Date 2023/03/07
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        // 双指针，减2，减少两次循环
        for (int i = 0; i < n - 2; i++) {
            // 第一个元素大于0，则直接返回
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去重
                continue;
            }
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 去重
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
