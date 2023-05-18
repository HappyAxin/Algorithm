package com.xin.hard.other;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/binary-tree-cameras/">968. 监控二叉树</a>
 * @Date 2023/05/18
 */
public class Solution968 {
    /**
     * 计数器，记录摄像头数量
     */
    private int cameras;

    public int minCameraCover(TreeNode root) {
        cameras = 0;
        // 从根节点开始递归遍历二叉树
        int state = dfs(root);
        if (state == 0) {
            // 如果根节点未被监控到，则在根节点安装摄像头
            cameras++;
        }
        return cameras;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            // 空节点不需要监控，返回2表示不需要监控
            return 2;
        }
        // 递归遍历左子树
        int left = dfs(node.left);
        // 递归遍历右子树
        int right = dfs(node.right);

        if (left == 0 || right == 0) {
            // 如果左子树或右子树的状态为0，表示当前节点未被监控到
            // 在当前节点安装摄像头
            cameras++;
            // 返回1表示当前节点已被监控
            return 1;
        } else if (left == 1 || right == 1) {
            // 如果左子树或右子树的状态为1，表示当前节点已被监控
            // 返回2表示当前节点不需要监控
            return 2;
        } else {
            // 如果左子树和右子树的状态都为2，表示当前节点未被监控且没有子节点被监控
            // 返回0表示当前节点未被监控
            return 0;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}