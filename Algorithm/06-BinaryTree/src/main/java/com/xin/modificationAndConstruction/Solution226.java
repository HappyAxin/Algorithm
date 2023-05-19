package com.xin.modificationAndConstruction;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/invert-binary-tree/">226. 翻转二叉树</a>
 * @Date 2023/04/06
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 递归翻转左子树
        TreeNode left = invertTree(root.left);
        // 递归翻转右子树
        TreeNode right = invertTree(root.right);
        // 交换左子树和右子树
        root.left = right;
        root.right = left;
        return root;
    }
}
