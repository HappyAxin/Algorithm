package com.xin.traversal.recursion;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description 145. 二叉树的后序遍历
 * @Link <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">145. 二叉树的后序遍历</a>
 * @Date 2023/03/23
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
        return res;
    }

    private void postorderHelper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        postorderHelper(node.left, res);
        postorderHelper(node.right, res);
        res.add(node.val);
    }
}
