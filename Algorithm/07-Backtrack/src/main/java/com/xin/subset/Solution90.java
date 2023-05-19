package com.xin.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/subsets-ii/">90. 子集II</a>
 * @Date 2023/05/16
 */
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void backtrack(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            // 跳过重复元素
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            currentSubset.add(nums[i]);
            backtrack(nums, i + 1, currentSubset, subsets);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
