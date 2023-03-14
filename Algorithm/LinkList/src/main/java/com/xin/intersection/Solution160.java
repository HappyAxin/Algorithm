package com.xin.intersection;

import com.xin.ListNode;

/**
 * @author Hu·YX
 * @Description 160.相交链表 同 面试题 02.07 链表相交
 * @Link <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">160.相交链表</a>
 * @Date 2023/03/03
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 分别遍历两个链表得到它们的长度
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // 让指向较长链表的指针向后移动使得两个链表的长度相同
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // 同时遍历两个链表直到找到第一个相同的节点
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        // 两个链表不存在相交节点
        return null;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
