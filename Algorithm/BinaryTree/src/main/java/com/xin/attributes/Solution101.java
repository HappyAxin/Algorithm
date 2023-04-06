package com.xin.attributes;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/symmetric-tree/">101. 对称二叉树</a>
 * @Date 2023/04/06
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 检查左右子树是否对称
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // 如果左右子树都为空，返回true
        if (left == null && right == null) {
            return true;
        }

        // 如果左右子树其中一个为空，返回false
        if (left == null || right == null) {
            return false;
        }

        // 如果左右子树根节点的值不同，返回false
        if (left.val != right.val) {
            return false;
        }

        // 递归检查左子树的左节点和右子树的右节点，
        // 以及左子树的右节点和右子树的左节点是否轴对称
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
