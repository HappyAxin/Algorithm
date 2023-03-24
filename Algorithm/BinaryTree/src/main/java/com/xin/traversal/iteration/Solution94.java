package com.xin.traversal.iteration;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hu·YX
 * @Description 94. 二叉树的中序遍历
 * @Link <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">94. 二叉树的中序遍历</a>
 * @Date 2023/03/23
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        // 当栈不为空或当前节点不为空时，循环处理节点
        while (curr != null || ! stack.isEmpty()) {
            // 先将左子节点依次入栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // 弹出栈顶节点并将其值加入结果集中
            curr = stack.pop();
            result.add(curr.val);
            // 处理右子节点
            curr = curr.right;
        }
        return result;
    }
}
