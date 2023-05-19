package com.xin.attributes;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/">700. 二叉搜索树中的搜索</a>
 * @Date 2023/04/14
 */
public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
