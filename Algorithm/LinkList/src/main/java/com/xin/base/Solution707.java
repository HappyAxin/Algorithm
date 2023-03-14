package com.xin.base;

/**
 * @author Hu·YX
 * @Description 707.设计链表
 * @Link <a href="https://leetcode.cn/problems/design-linked-list/">707.设计链表</a>
 * @Date 2023/03/03
 */
public class Solution707 {

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

/**
 * 单链表实现
 */
class MySingleLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private ListNode head;
    private int size;

    public MySingleLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return - 1;
        }
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
        } else {
            ListNode newNode = new ListNode(val);
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            size++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index > 0 && index < size) {
            ListNode newNode = new ListNode(val);
            ListNode curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            ListNode curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }
}

/**
 * 双链表实现
 */
class MyDoubleLinkedList {
    private int size;
    private ListNode head;
    private ListNode tail;

    private static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 初始化数据结构。
     */
    public MyDoubleLinkedList() {
        size = 0;
        head = new ListNode(- 1);
        tail = new ListNode(- 1);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 获取链表中第 index 个节点的值。 如果索引无效，则返回 -1。
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return - 1;
        }
        ListNode cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。 插入后，新节点将成为链表的第一个节点。
     */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    /**
     * 将值为 val 的节点附加到链表的最后一个元素。
     */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    /**
     * 在链表的第 index 个节点之前添加一个值为 val 的节点。 如果索引等于链表的长度，则该节点将追加到链表的末尾。 如果索引大于长度，则不会插入该节点。
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            addAtHead(val);
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.prev = cur;
        newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next = newNode;
        size++;
    }

    /**
     * 如果索引有效，则删除链表中的第 index 个节点。
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        cur.next.prev = cur;
        size--;
    }
}
