package com.xin.traversal.levelorder;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hu·YX
 * @Description 107. 二叉树的层序遍历 II
 * @Link <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/">107. 二叉树的层序遍历 II</a>
 * @Date 2023/03/24
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 将该层节点的值列表添加到结果列表的头部
            res.add(0, level);
        }
        return res;
    }
}
