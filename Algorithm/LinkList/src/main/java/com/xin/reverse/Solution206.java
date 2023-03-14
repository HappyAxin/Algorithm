package com.xin.reverse;

import com.xin.ListNode;

/**
 * @author Hu·YX
 * @Description 206.反转链表
 * @Link <a href="https://leetcode.cn/problems/reverse-linked-list/">206.反转链表</a>
 * @Date 2023/03/03
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
