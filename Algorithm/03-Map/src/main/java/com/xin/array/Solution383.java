package com.xin.array;

/**
 * @author Hu·YX
 * @Description 383.赎金信
 * @Link <a href="https://leetcode.cn/problems/ransom-note/">383.赎金信</a>
 * @Date 2023/03/06
 */
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        // 统计 magazine 中每个字符出现的次数
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        // 在 count 中减去 ransomNote 中出现的字符次数，如果出现负数则说明构造不了
        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i) - 'a']--;
            if (count[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
