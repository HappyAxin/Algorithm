package com.xin.modificationAndConstruction;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/delete-node-in-a-bst/">450. 删除二叉搜索树中的节点</a>
 * @Date 2023/04/14
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 找到要删除的节点
            if (root.left == null && root.right == null) {
                // 情况 1：要删除的节点是叶子节点
                root = null;
            } else if (root.right != null) {
                // 情况 3：要删除的节点有两个子节点
                TreeNode successor = getMin(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            } else {
                // 情况 2：要删除的节点只有一个子节点
                root = root.left != null ? root.left : root.right;
            }
        }
        return root;
    }

    /**
     * 获取以 root 为根节点的子树中的最小节点
     *
     * @param root root
     * @return TreeNode
     */
    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
