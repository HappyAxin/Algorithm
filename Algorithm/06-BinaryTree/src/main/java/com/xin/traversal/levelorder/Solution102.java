package com.xin.traversal.levelorder;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hu·YX
 * @Description 102. 二叉树的层序遍历
 * @Link <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">102. 二叉树的层序遍历</a>
 * @Date 2023/03/24
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 初始化一个队列，用于存放节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 队列不为空时，循环遍历
        while (!queue.isEmpty()) {
            // 获取当前队列的大小，即该层节点的数量
            int size = queue.size();
            // 用于存放该层节点的值的列表
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 从队列中取出一个节点
                TreeNode node = queue.poll();
                // 将该节点的值添加到该层节点的值列表中
                level.add(node.val);
                // 如果该节点的左子节点不为空，将其加入队列中
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 如果该节点的右子节点不为空，将其加入队列中
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
