package com.xin.arrangement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/permutations-ii/">47. 全排列 II</a>
 * @Date 2023/05/16
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        // 用于去重
        Set<List<Integer>> uniquePermutations = new HashSet<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], permutations, uniquePermutations);
        return permutations;
    }

    private void backtrack(int[] nums, List<Integer> currentPermutation, boolean[] used, List<List<Integer>> permutations, Set<List<Integer>> uniquePermutations) {
        if (currentPermutation.size() == nums.length) {
            if (uniquePermutations.add(currentPermutation)) {
                permutations.add(new ArrayList<>(currentPermutation));
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                // 跳过已使用过的数字
                continue;
            }
            currentPermutation.add(nums[i]);
            used[i] = true;
            backtrack(nums, currentPermutation, used, permutations, uniquePermutations);
            used[i] = false;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}
