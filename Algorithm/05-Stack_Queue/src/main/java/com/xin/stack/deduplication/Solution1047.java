package com.xin.stack.deduplication;

import java.util.Stack;

/**
 * @author Hu·YX
 * @Description 1047. 删除字符串中的所有相邻重复项
 * @Link <a href="https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/">1047. 删除字符串中的所有相邻重复项</a>
 * @Date 2023/03/22
 */
public class Solution1047 {
    public String removeDuplicates(String s) {
        // 创建一个栈来存储字符
        Stack<Character> stack = new Stack<>();
        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            // 如果栈不为空且栈顶元素和当前字符相同
            if (!stack.isEmpty() && stack.peek() == c) {
                // 弹出栈顶元素
                stack.pop();
            } else {
                // 否则将当前字符压入栈中
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历栈中的字符
        for (char c : stack) {
            // 将字符添加到StringBuilder中
            stringBuilder.append(c);
        }
        // 将StringBuilder转换成字符串并返回
        return stringBuilder.toString();
    }
}
