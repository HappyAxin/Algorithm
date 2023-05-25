package com.xin.robbery;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/house-robber-iii/">337. 打家劫舍 III</a>
 * @Date 2023/05/25
 */
public class Solution337 {
    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * 返回一个大小为2的数组，分别表示偷窃该节点和不偷窃该节点的最大金额
     *
     * @param node 二叉树节点
     * @return int[]
     */
    private int[] robHelper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);

        // 偷窃当前节点的最大金额是当前节点的价值加上不偷窃左右子节点的最大金额
        int robValue = node.val + left[1] + right[1];

        // 不偷窃当前节点的最大金额是左右子节点的最大金额之和
        int skipValue = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robValue, skipValue};
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