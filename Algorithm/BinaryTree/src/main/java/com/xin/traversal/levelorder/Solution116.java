package com.xin.traversal.levelorder;

import com.xin.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hu·YX
 * @Description 116. 填充每个节点的下一个右侧节点指针
 * @Link <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/">116. 填充每个节点的下一个右侧节点指针</a>
 * @Date 2023/03/27
 */
public class Solution116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 上一个节点
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                // 如果 prev 不为 null，说明上一个节点已经遍历过了，连接它和当前节点
                if (prev != null) {
                    prev.next = cur;
                }
                // 更新prev
                prev = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }
}
