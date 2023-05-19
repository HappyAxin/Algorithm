package com.xin.traversal.iteration;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hu·YX
 * @Description 144. 二叉树的前序遍历
 * @Link <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">144. 二叉树的前序遍历</a>
 * @Date 2023/03/23
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 创建栈模拟递归过程
        Stack<TreeNode> stack = new Stack<>();
        // 将根节点入栈
        stack.push(root);
        // 当栈不为空时，循环处理节点
        while (! stack.isEmpty()){
            // 弹出栈顶节点
            TreeNode node = stack.pop();
            // 将节点值加入结果集
            result.add(node.val);
            // 将右节点入栈，保证优先处理左节点
            if (node.right != null) {
                stack.push(node.right);
            }
            // 将左节点入栈
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
