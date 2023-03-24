package com.xin.traversal.recursion;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description 144. 二叉树的前序遍历
 * @Link <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">144. 二叉树的前序遍历</a>
 * @Date 2023/03/23
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderHelper(root, res);
        return res;
    }

    private void preorderHelper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorderHelper(node.left, res);
        preorderHelper(node.right, res);
    }
}
