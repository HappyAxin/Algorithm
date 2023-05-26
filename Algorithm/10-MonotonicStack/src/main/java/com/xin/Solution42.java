package com.xin;

import java.util.Stack;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/trapping-rain-water/">42. 接雨水</a>
 * @Date 2023/05/26
 */
public class Solution42 {
    public int trap(int[] height) {
        int n = height.length;
        // 存储接雨水的总量
        int water = 0;
        // 单调递减栈，存储柱子的索引
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (! stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 当前栈顶柱子的索引
                int topIndex = stack.pop();
                if (stack.isEmpty()) {
                    // 栈为空，无法形成凹槽
                    break;
                }
                // 左边界柱子的索引
                int leftIndex = stack.peek();
                // 凹槽的宽度
                int distance = i - leftIndex - 1;
                // 凹槽的高度
                int boundedHeight = Math.min(height[i], height[leftIndex]) - height[topIndex];
                // 累加接雨水的量
                water += distance * boundedHeight;
            }
            stack.push(i);
        }

        return water;
    }
}
