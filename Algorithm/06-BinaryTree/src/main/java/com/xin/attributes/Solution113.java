package com.xin.attributes;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/path-sum-ii/">113. 路径总和 II</a>
 * @Date 2023/04/13
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(root, targetSum, path, res);
        return res;
    }

    private void backtrack(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null && node.val == targetSum) {
            res.add(new ArrayList<>(path));
        } else {
            backtrack(node.left, targetSum - node.val, path, res);
            backtrack(node.right, targetSum - node.val, path, res);
        }
        path.remove(path.size() - 1);
    }
}
