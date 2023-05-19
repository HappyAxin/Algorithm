package com.xin.modificationAndConstruction;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/insert-into-a-binary-search-tree/">701. 二叉搜索树中的插入操作</a>
 * @Date 2023/04/14
 */
public class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果根节点为空，直接将值作为根节点返回
        if (root == null) {
            return new TreeNode(val);
        }

        // 如果要插入的值小于当前节点的值，则将其插入到左子树中
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        // 如果要插入的值大于当前节点的值，则将其插入到右子树中
        else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
