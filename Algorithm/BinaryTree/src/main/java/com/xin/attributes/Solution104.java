package com.xin.attributes;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>>
 * @Date 2023/04/06
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树的最大深度
        int leftDepth = maxDepth(root.left);
        // 右子树的最大深度
        int rightDepth = maxDepth(root.right);
        // 返回左右子树的最大深度+1
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
