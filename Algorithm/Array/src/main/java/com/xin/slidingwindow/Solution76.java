package com.xin.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description 最小覆盖子串
 * @Link <a href="https://leetcode.cn/problems/minimum-window-substring/">76.最小覆盖子串</a>
 * @Date 2023/01/11
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // 记录 t 中每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口左边界
        int left = 0;
        // 滑动窗口右边界
        int right = 0;
        // 记录当前窗口中 t 中字符出现的次数
        int count = 0;
        // 记录最小子串的长度
        int minLength = Integer.MAX_VALUE;
        // 最小子串的左边界
        int minLeft = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                // t 中仍然需要这个字符
                if (map.get(c) >= 0) {
                    count++;
                }
            }
            // 当前窗口已经包含了 t 中所有字符
            while (count == t.length()) {
                // 更新最小子串的长度和左边界
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                // 左边界移动
                char lc = s.charAt(left);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    // t 中缺失这个字符了
                    if (map.get(lc) > 0) {
                        count--;
                    }
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
