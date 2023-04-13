package com.xin.stack.system;

import java.util.Stack;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/simplify-path/">71. 简化路径</a>
 * @Date 2023/04/13
 */
public class Solution71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.isEmpty() || ".".equals(dir)) {
                continue;
            } else if ("..".equals(dir)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String dir : stack) {
            stringBuilder.append("/").append(dir);
        }
        return stringBuilder.length() == 0 ? "/" : stringBuilder.toString();
    }
}
