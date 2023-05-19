package com.xin.kmp;

/**
 * @author Hu·YX
 * @Description 459. 重复的子字符串
 * @Link <a href="https://leetcode.cn/problems/repeated-substring-pattern">459. 重复的子字符串</a>
 * @Date 2023/03/10
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        // 获取原字符串的next数组
        int[] next = getNext(s);
        // 最长重复子串
        int len = n - next[n];
        // 如果最长重复子串的长度等于原字符串长度，说明原字符串不能由子串重复多次构成，返回false
        // 如果最长重复子串的长度不等于原字符串长度，但原字符串长度不是最长重复子串长度的整数倍，也返回false
        return len != n && n % len == 0;
    }

    private int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n + 1];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < n) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
