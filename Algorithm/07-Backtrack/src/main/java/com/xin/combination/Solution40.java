package com.xin.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/combination-sum-ii/">40. 组合总和 II</a>
 * @Date 2023/04/25
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 如果当前候选数已经被用过，或者当前候选数与前一个候选数相同且前一个候选数没有被用过，就跳过
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            backtrack(result, temp, candidates, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
