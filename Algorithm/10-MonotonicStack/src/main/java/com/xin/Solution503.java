package com.xin;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/next-greater-element-ii/">503. 下一个更大元素 II</a>
 * @Date 2023/05/26
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // 初始化答案数组为-1
        Arrays.fill(ans, - 1);
        // 单调递减栈，存储元素的索引
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (! stack.isEmpty() && num > nums[stack.peek()]) {
                ans[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }

        return ans;
    }
}
