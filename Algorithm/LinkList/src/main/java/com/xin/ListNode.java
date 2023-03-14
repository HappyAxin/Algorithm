package com.xin;

/**
 * @author Hu·YX
 * @Description Definition for singly-linked list.
 * @Date 2023/03/14
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ;

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
