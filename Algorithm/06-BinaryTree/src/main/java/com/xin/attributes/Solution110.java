package com.xin.attributes;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/balanced-binary-tree/">110. 平衡二叉树</a>
 * @Date 2023/04/06
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            // 空树是高度平衡二叉树
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        // 判断左右子树的高度是否小于等于1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        // 判断左右子树是否都是高度平衡的二叉树
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        // 二叉树的高度等于左右子树高度较大值+1
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
