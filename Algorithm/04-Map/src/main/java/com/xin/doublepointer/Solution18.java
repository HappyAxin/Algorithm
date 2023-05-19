package com.xin.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hu·YX
 * @Description 18. 四数之和
 * @Link <a href="https://leetcode.cn/problems/4sum/">18. 四数之和</a>
 * @Date 2023/03/09
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        // 外层循环枚举第一个数
        for (int i = 0; i < n - 3; i++) {
            // 跳过重复的值
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 内存循环枚举第二个数
            for (int j = i + 1; j < n - 2; j++) {
                // 跳过重复值
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = n - 1;
                while (left < right) {
                    // 计算四数之和
                    // nums: [1000000000,1000000000,1000000000,1000000000]
                    // target: -294967296
                    // 上面这组测试用例会溢出，故转成long
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
