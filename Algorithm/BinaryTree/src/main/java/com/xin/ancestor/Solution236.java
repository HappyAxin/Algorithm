package com.xin.ancestor;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/">236. 二叉树的最近公共祖先</a>
 * @Date 2023/04/14
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
