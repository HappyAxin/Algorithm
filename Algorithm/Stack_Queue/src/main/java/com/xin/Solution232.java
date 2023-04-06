package com.xin;

import java.util.Stack;

/**
 * @author Hu·YX
 * @Description 232. 用栈实现队列
 * @Link <a href="https://leetcode.cn/problems/implement-queue-using-stacks/">232. 用栈实现队列</a>
 * @Date 2023/03/14
 */
public class Solution232 {
}

class MyQueue {

    /**
     * 输入栈
     */
    private Stack<Integer> inputStack;

    /**
     * 输出栈
     */
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /**
     * 入列
     *
     * @param x
     */
    public void push(int x) {
        // 将元素压入输入栈
        inputStack.push(x);
    }

    /**
     * 出列
     *
     * @return int
     */
    public int pop() {
        // 先调用 peek() 方法将输入栈中的元素全部压入输出栈中
        peek();
        // 弹出输出栈的栈顶元素
        return outputStack.pop();
    }

    /**
     * 返回队列开头元素
     *
     * @return int
     */
    public int peek() {
        // 如果输出栈为空，则将输入栈中的元素全部压入输出栈
        if (outputStack.isEmpty()) {
            while (! inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        // 返回输出栈的栈顶元素
        return outputStack.peek();
    }

    /**
     * 判空
     *
     * @return boolean
     */
    public boolean empty() {
        // 如果输入栈和输出栈都为空，则队列为空
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

}