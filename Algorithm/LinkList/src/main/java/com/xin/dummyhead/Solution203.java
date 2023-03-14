package com.xin.dummyhead;


import com.xin.ListNode;

/**
 * @author Hu·YX
 * @Description 203.移除链表元素
 * @Link <a href="https://leetcode.cn/problems/remove-linked-list-elements/">203.移除链表元素</a>
 * @Date 2023/03/03
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        // 处理链表头的值等于val的节点
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode node = head.next;

        while (node != null) {
            if (node.val == val) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = node.next;
        }
        return head;
    }
}
