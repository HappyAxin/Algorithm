package com.xin;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hu·YX
 * @Description 225. 用队列实现栈
 * @Link <a href="https://leetcode.cn/problems/implement-stack-using-queues/">225. 用队列实现栈</a>
 * @Date 2023/03/14
 */
public class Solution225 {
}

class MyStack {

    /**
     * 主队列
     */
    private Queue<Integer> mainQueue;

    /**
     * 辅助队列
     */
    private Queue<Integer> auxQueue;

    public MyStack() {
        mainQueue = new LinkedList<>();
        auxQueue = new LinkedList<>();
    }

    public void push(int x) {
        // 将元素插入主队列的队尾
        mainQueue.offer(x);
    }

    public int pop() {
        // 将主队列中的元素依次弹出并插入辅助队列中，直到主队列中只剩下一个元素
        while (mainQueue.size() > 1) {
            auxQueue.offer(mainQueue.poll());
        }
        // 弹出主队列的最后一个元素，即栈顶元素
        int top = mainQueue.poll();
        swapQueues();
        // 返回栈顶元素
        return top;
    }

    public int top() {
        // 将主队列中的元素依次弹出并插入辅助队列中，直到主队列中只剩下一个元素
        while (mainQueue.size() > 1) {
            auxQueue.offer(mainQueue.poll());
        }
        // 弹出主队列的最后一个元素，即栈顶元素
        int top = mainQueue.poll();
        // 将栈顶元素插入辅助队列队尾
        auxQueue.offer(top);
        swapQueues();
        // 返回栈顶元素
        return top;
    }

    public boolean empty() {
        // 判断主队列是否为空即可
        return mainQueue.isEmpty();
    }

    /**
     * 将辅助队列中的元素重新插入主队列，使得主队列中额元素顺序不变
     */
    private void swapQueues() {
        Queue<Integer> temp = mainQueue;
        mainQueue = auxQueue;
        auxQueue = temp;
    }
}
