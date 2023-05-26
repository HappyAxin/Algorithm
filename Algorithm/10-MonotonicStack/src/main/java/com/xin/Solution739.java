package com.xin;

import java.util.Stack;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/daily-temperatures/">739. 每日温度</a>
 * @Date 2023/05/26
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        // 单调递减栈，存储温度数组的索引
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (! stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        return answer;
    }
}
