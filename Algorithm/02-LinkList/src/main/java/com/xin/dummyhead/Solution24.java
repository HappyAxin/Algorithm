package com.xin.dummyhead;

import com.xin.ListNode;

/**
 * @author Hu·YX
 * @Description 24. 两两交换链表中的节点
 * @Link <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/">24. 两两交换链表中的节点</a>
 * @Date 2023/03/03
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        // 如果链表为空或者链表中只有一个节点，直接返回头节点
        if (head == null || head.next == null) {
            return head;
        }

        // 记录下一个节点，即 node2
        ListNode nextNode = head.next;
        // 递归处理 node2 后面的节点
        head.next = swapPairs(nextNode.next);
        // 将 node1 的 next 指向 node2 的下一个节点
        nextNode.next = head;
        // 返回新的头节点
        return nextNode;
    }
}
