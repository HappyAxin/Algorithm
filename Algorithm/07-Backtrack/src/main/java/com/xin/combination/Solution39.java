package com.xin.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/combination-sum/">39. 组合总和</a>
 * @Date 2023/04/25
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        // 从数组的第一个位置开始搜索
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int start) {
        // 如果目标数为0，说明找到了一组可行的组合
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // 从start位置开始搜索候选数
        for (int i = start; i < candidates.length; i++) {
            // 如果当前候选数大于目标数，说明后面的候选数都太大，不可能有合法的组合了，直接退出循环
            if (candidates[i] > target) {
                break;
            }
            // 将当前候选数添加到中间结果列表中
            temp.add(candidates[i]);
            // 递归搜索目标数减去当前候选数后的所有可能组合
            // 注意：这里从i位置开始搜索，因为同一个候选数可以使用无数次
            backtrack(result, temp, candidates, target - candidates[i], i);
            // 回溯到上一个状态，将当前候选数从中间结果列表中删除
            temp.remove(temp.size() - 1);
        }
    }
}
