package com.xin.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/subsets/">78. 子集</a>
 * @Date 2023/04/25
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void backtrack(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> subsets) {
        // 将当前子集添加到结果集
        subsets.add(new ArrayList<>(currentSubset));

        // 从start位置开始遍历数组
        for (int i = start; i < nums.length; i++) {
            // 将当前元素添加到子集
            currentSubset.add(nums[i]);
            // 递归生成以当前元素为起点的子集
            backtrack(nums, i + 1, currentSubset, subsets);
            // 回溯，将当前元素从当前子集中移除
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
