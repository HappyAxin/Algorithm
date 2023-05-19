package com.xin.modificationAndConstruction;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/trim-a-binary-search-tree/">669. 修剪二叉搜索树</a>
 * @Date 2023/04/14
 */
public class Solution669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 如果根节点为空，则直接返回null
        if (root == null) {
            return null;
        }
        // 如果根节点的值小于low，则需要修剪左子树
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // 如果根节点的值大于high，则需要修剪右子树
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // 修剪左子树
        root.left = trimBST(root.left, low, high);
        // 修剪右子树
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
