package com.xin.attributes;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/">530. 二叉搜索树的最小绝对差</a>
 * @Date 2023/04/14
 */
public class Solution530 {
    /**
     * 上一个遍历到的节点的值
     */
    int prev = - 1;

    /**
     * 记录最小差值
     */
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev != - 1) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        inorder(node.right);
    }
}
