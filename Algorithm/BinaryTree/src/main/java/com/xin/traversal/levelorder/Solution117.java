package com.xin.traversal.levelorder;

import com.xin.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hu·YX
 * @Description 117. 填充每个节点的下一个右侧节点指针 II
 * @Link <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii">117. 填充每个节点的下一个右侧节点指针 II</a>
 * @Date 2023/03/27
 */
public class Solution117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (! queue.isEmpty()) {
            int size = queue.size();
            // 上一个节点
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                // 如果 prev 不为 null，说明上一个节点已经遍历过了，连接它和当前节点
                if (prev != null) {
                    prev.next = cur;
                }
                prev = cur;
            }
        }
        return root;
    }
}
