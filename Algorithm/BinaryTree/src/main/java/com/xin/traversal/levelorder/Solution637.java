package com.xin.traversal.levelorder;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hu·YX
 * @Description 637. 二叉树的层平均值
 * @Link <a href="https://leetcode.cn/problems/average-of-levels-in-binary-tree/">637. 二叉树的层平均值</a>
 * @Date 2023/03/24
 */
public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 将节点值加到 sum 上
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 计算该层节点的平均值
            double svg = sum / size;
            res.add(svg);
        }
        return res;
    }
}
