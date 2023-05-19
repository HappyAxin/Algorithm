package com.xin.traversal.levelorder;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hu·YX
 * @Description 515. 在每个树行中找最大值
 * @Link <a href="https://leetcode.cn/problems/find-largest-value-in-each-tree-row/">515. 在每个树行中找最大值</a>
 * @Date 2023/03/27
 */
public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                maxVal = Math.max(maxVal, cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(maxVal);
        }
        return res;
    }
}
