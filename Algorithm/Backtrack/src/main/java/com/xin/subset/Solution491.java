package com.xin.subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/non-decreasing-subsequences/">491. 递增子序列</a>
 * @Date 2023/05/16
 */
public class Solution491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> subsequences = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsequences);
        return subsequences;
    }

    private void backtrack(int[] nums, int start, List<Integer> currentSequence,  List<List<Integer>> subsequences) {
        if (currentSequence.size() >= 2) {
            subsequences.add(new ArrayList<>(currentSequence));
        }

        // 用于去重
        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                // 跳过重复元素
                continue;
            }
            if (currentSequence.isEmpty() || nums[i] >= currentSequence.get(currentSequence.size() - 1)) {
                used.add(nums[i]);
                currentSequence.add(nums[i]);
                backtrack(nums, i + 1, currentSequence, subsequences);
                currentSequence.remove(currentSequence.size() - 1);
            }
        }
    }
}
