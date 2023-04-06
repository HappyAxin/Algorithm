package com.xin.attributes;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/">111. 二叉树的最小深度</a>>
 * @Date 2023/04/06
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果左子树为空，返回右子树的最小深度+1
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        // 如果右子树为空，返回左子树的最小深度+1
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        // 左子树的最小深度
        int leftDepth = minDepth(root.left);
        // 右子树的最小深度
        int rightDepth = minDepth(root.right);
        // 返回左右子树的最小深度+1
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
