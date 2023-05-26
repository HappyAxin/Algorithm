package com.xin;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/next-greater-element-i/">496. 下一个更大元素 I</a>
 * @Date 2023/05/26
 */
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 存储元素及其下一个更大元素的映射
        Map<Integer, Integer> map = new HashMap<>();
        // 单调递减栈，存储元素
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (! stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], - 1);
        }

        return ans;
    }
}
