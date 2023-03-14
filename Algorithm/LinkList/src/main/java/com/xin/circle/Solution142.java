package com.xin.circle;

import com.xin.ListNode;
/**
 * @author Hu·YX
 * @Description 142.环形链表II
 * @Link <a href="https://leetcode.cn/problems/linked-list-cycle-ii/">142.环形链表II</a>
 * @Date 2023/03/03
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 判断是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // 如果没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        // 寻找环的起点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
