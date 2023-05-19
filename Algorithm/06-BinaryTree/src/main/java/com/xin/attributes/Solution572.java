package com.xin.attributes;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/subtree-of-another-tree/">572. 另一棵树的子树</a>
 * @Date 2023/04/06
 */
public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 如果子树为空，返回true
        if (subRoot == null) {
            return true;
        }

        // 如果树为空，返回false
        if (root == null) {
            return false;
        }

        // 判断树与子树的根节点是否相同，如果相同，则递归检查左右子树是否相同
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // 如果根节点不同，则递归检查左右子树是否包含与子树相同的结构和节点值的子树
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两棵树都为空，返回true
        if (p == null && q == null) {
            return true;
        }

        // 如果两棵树其中一个为空，或者节点的值不同，返回false
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // 递归检查左右子树是否相同
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
