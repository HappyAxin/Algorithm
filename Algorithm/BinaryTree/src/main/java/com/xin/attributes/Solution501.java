package com.xin.attributes;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/find-mode-in-binary-search-tree/">501. 二叉搜索树中的众数</a>
 * @Date 2023/04/14
 */
public class Solution501 {
    Map<Integer, Integer> map = new HashMap<>();

    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        inorder(root);

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                list.add(key);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        int count = map.getOrDefault(root.val, 0) + 1;
        map.put(root.val, count);
        maxCount = Math.max(maxCount, count);
        inorder(root.right);
    }
}
