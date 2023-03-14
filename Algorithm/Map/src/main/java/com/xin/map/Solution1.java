package com.xin.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description 1. 两数之和
 * @Link <a href="https://leetcode.cn/problems/two-sum">1. 两数之和</a>
 * @Date 2023/03/07
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表 map，键为数组中的元素，值为该元素的索引。
        Map<Integer, Integer> map = new HashMap<>(2);
        // 遍历数组 nums
        for (int i = 0; i < nums.length; i++) {
            // 对于每个元素 nums[i]，计算它的补数 complement = target - nums[i]。
            int complement = target - nums[i];
            // 判断补数 complement 是否在哈希表 map 中，若在，则找到了满足条件的两个元素，它们的索引分别为 map.get(complement) 和 i。
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            // 若补数 complement 不在哈希表 map 中，则将当前元素及其索引放入哈希表中。
            map.put(nums[i], i);
        }
        // 未找到返回空数组
        return new int[0];
    }
}
