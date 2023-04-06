package com.xin.attributes;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数</a>
 * @Date 2023/04/06
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            // 左子树是满二叉树
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            // 右子树是满二叉树
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}
