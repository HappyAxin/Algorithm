package com.xin.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description 438. 找到字符串中所有字母异位词
 * @Link <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">438. 找到字符串中所有字母异位词</a>
 * @Date 2023/03/06
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }
        // 构建两个长度为 26 的数组 target 和 window，分别用于存储目标字符串 p 中各个字符出现的次数和当前窗口中各个字符出现的次数。
        int[] target = new int[26];
        int[] window = new int[26];
        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }
        // 遍历字符串 s，用滑动窗口维护一个长度为 p.length() 的窗口，记录窗口左右端点 left 和 right，
        // 以及当前窗口中满足 target[c] <= window[c] 条件的字符个数 count。
        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 将对应的字符 c 的出现次数加 1。
            window[c - 'a']++;
            // 如果 window[c] <= target[c]，则将 count 加 1。
            if (window[c - 'a'] <= target[c - 'a']) {
                count++;
            }
            // 如果当前 count 的值等于 p.length()，则表示当前窗口中的字符构成了 p 的异位词。
            while (count == p.length()) {
                // 此时，如果窗口的长度等于 p.length()，则将窗口左端点 left 加入结果列表中；否则，将 left 向右移动一位，并将对应的字符 d 的出现次数减 1。
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                window[d - 'a']--;
                // 如果 window[d] < target[d]，则将 count 减 1。
                if (window[d - 'a'] < target[d - 'a']) {
                    count--;
                }
                left++;
            }
            // 在遍历过程中，每次将右端点 right 向右移动一位。
            right++;
        }
        return res;
    }
}
