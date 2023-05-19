package com.xin.traversal.levelorder;

import com.xin.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hu·YX
 * @Description 429. N 叉树的层序遍历
 * @Link <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal/">429. N 叉树的层序遍历</a>
 * @Date 2023/03/27
 */
public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                level.add(cur.val);
                for (Node child : cur.children) {
                    if (child != null) {
                        // 如果子节点不为空，将其入队
                        queue.offer(child);
                    }
                }
            }
            res.add(level);
        }
        return res;
    }
}
