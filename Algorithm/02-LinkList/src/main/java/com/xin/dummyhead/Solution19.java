package com.xin.dummyhead;

import com.xin.ListNode;

/**
 * @author Hu·YX
 * @Description 19.删除链表的倒数第 N 个结点
 * @Link <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">19.删除链表的倒数第 N 个结点</a>
 * @Date 2023/03/03
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
