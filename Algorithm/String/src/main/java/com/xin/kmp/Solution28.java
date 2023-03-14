package com.xin.kmp;

/**
 * @author Hu·YX
 * @Description 28. 找出字符串中第一个匹配项的下标
 * @Link <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/">28. 找出字符串中第一个匹配项的下标</a>
 * @Date 2023/03/10
 */
public class Solution28 {
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int n = haystack.length(), m = needle.length();

        // 计算needle字符串的前缀信息
        // next数组记录每个位置的前缀信息
        int[] next = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                // 如果前缀不匹配，则跳到上一个最长前缀的位置
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                // 如果前缀匹配则最长前缀长度加1
                j++;
            }
            // 记录最长前缀长度
            next[i] = j;
        }
        // 在haystack字符串中匹配needle字符串
        j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                // 如果字符不匹配，则跳到上一个最长前缀的位置
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                // 如果字符匹配，则将最长前缀长度加1
                j++;
            }
            if (j == m) {
                // 如果达到了needle字符串长度，则匹配成功，返回匹配的起始位置
                return i - j + 1;
            }
        }
        return - 1;
    }

}
