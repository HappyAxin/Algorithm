package com.xin.attributes;

import com.xin.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/">513. 找树左下角的值</a>
 * @Date 2023/04/13
 */
public class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 记录最左边节点的值
        int leftmostValue = root.val;
        while (! queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    // 第一个节点是该层的最左边节点
                    leftmostValue = curr.val;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return leftmostValue;
    }
}
