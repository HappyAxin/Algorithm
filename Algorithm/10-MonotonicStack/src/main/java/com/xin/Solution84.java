package com.xin;

import java.util.Stack;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram/">84. 柱状图中最大的矩形</a>
 * @Date 2023/05/26
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 存储最大矩形面积
        int maxArea = 0;
        // 单调递增栈，存储柱子的索引
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            // 添加高度为0的柱子作为哨兵
            int h = (i == n) ? 0 : heights[i];
            while (! stack.isEmpty() && h < heights[stack.peek()]) {
                // 当前栈顶柱子的高度
                int height = heights[stack.pop()];
                // 当前矩形的宽度
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // 当前矩形的面积
                int area = height * width;
                // 更新最大矩形面积
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
