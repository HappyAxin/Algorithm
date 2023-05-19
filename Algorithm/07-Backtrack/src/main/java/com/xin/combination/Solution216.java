package com.xin.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/combination-sum-iii/">216. 组合总和 III</a>
 * @Date 2023/04/17
 */
public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[10];
        backtrack(res, new ArrayList<>(), used, k, n, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, boolean[] used, int k, int n, int start) {
        if (cur.size() == k && n == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (! used[i] && n >= i) {
                cur.add(i);
                used[i] = true;
                backtrack(res, cur, used, k, n - i, i + 1);
                used[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
