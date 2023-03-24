package com.xin.traversal.recursion;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description 94. 二叉树的中序遍历
 * @Link <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">94. 二叉树的中序遍历</a>
 * @Date 2023/03/23
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }

    private void inorderHelper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorderHelper(node.left, res);
        res.add(node.val);
        inorderHelper(node.right, res);
    }
}
