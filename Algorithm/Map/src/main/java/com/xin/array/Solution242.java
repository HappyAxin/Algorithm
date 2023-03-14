package com.xin.array;

/**
 * @author Hu·YX
 * @Description 242. 有效的字母异位词
 * @Link <a href="https://leetcode.cn/problems/valid-anagram/">242. 有效的字母异位词</a>
 * @Date 2023/03/03
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 统计s中每个字符出现的次数
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // 在count中减去t中出现的字符次数，如果出现负数返回false
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
