package com.xin.stack.bracket;

import java.util.Stack;

/**
 * @author Hu·YX
 * @Description 20. 有效的括号
 * @Link <a href="https://leetcode.cn/problems/valid-parentheses">20. 有效的括号</a>
 * @Date 2023/03/14
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // 当遇到左括号时，将其入栈
                stack.push(c);
            } else if (c == ')' && ! stack.isEmpty() && stack.peek() == '(') {
                // 当遇到右括号时，判断栈顶的左括号是否与之匹配，如果匹配则将其出栈
                stack.pop();
            } else if (c == ']' && ! stack.isEmpty() && stack.peek() == '[') {
                // 当遇到右括号时，判断栈顶的左括号是否与之匹配，如果匹配则将其出栈
                stack.pop();
            } else if (c == '}' && ! stack.isEmpty() && stack.peek() == '{') {
                // 当遇到右括号时，判断栈顶的左括号是否与之匹配，如果匹配则将其出栈
                stack.pop();
            } else {
                // 在任何时候遇到无法匹配的右括号或者栈为空时仍有右括号，返回 false
                return false;
            }
        }
        // 判断栈是否为空，如果为空则说明所有的括号都已匹配，返回 true；否则返回 false
        return stack.isEmpty();
    }
}
