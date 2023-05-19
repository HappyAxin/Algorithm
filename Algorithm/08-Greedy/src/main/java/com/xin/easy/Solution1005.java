package com.xin.easy;

import java.util.Arrays;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/">1005. K 次取反后最大化的数组和</a>
 * @Date 2023/05/17
 */
public class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 对数组进行排序
        Arrays.sort(nums);

        int i = 0;

        // 遍历数组，将负数变为正数，直到负数用完或者达到k次
        while (k > 0 && i < nums.length && nums[i] < 0) {
            nums[i] = - nums[i];
            i++;
            k--;
        }

        // 如果还有剩余的k次操作，且k为奇数，则将数组中的最小值取反
        if (k % 2 == 1) {
            // 找到数组中的最小值
            int minNum = Integer.MAX_VALUE;
            for (int num : nums) {
                minNum = Math.min(minNum, num);
            }

            // 将最小值取反
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == minNum) {
                    nums[j] = - nums[j];
                    break;
                }
            }
        }

        // 计算数组的和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}
