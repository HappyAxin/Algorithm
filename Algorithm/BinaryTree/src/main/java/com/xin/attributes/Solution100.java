package com.xin.attributes;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/same-tree/">100. 相同的树</a>
 * @Date 2023/04/06
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
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
