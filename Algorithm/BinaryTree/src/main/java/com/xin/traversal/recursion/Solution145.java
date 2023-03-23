package com.xin.traversal.recursion;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hu·YX
 * @Description 145. 二叉树的后序遍历
 * @Link <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">145. 二叉树的后序遍历</a>
 * @Date 2023/03/23
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 将节点值插入到结果集的开头
            result.add(0, node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }
}
