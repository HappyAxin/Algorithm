package com.xin.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/combinations/">77. 组合</a>
 * @Date 2023/04/17
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int n, int k, int start) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // 如果剩余可选的数字数量不足以组成一个组合，就返回
        if (n - start + 1 < k - cur.size()) {
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            backtrack(res, cur, n, k, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
