package com.xin.modificationAndConstruction;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/convert-bst-to-greater-tree/">538. 把二叉搜索树转换为累加树</a>
 * @Date 2023/04/14
 */
public class Solution538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
