package com.xin.arrangement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/permutations/">46. 全排列</a>
 * @Date 2023/05/16
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private void backtrack(int[] nums, List<Integer> currentPermutation, List<List<Integer>> permutations) {
        if (currentPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int num : nums) {
            if (!currentPermutation.contains(num)) {
                currentPermutation.add(num);
                backtrack(nums, currentPermutation, permutations);
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }
}
