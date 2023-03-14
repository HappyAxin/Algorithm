package com.xin.doublepointer;

/**
 * @author Hu·YX
 * @Description 541. 反转字符串 II
 * @Link <a href="https://leetcode.cn/problems/reverse-string-ii/">541. 反转字符串 II</a>
 * @Date 2023/03/09
 */
public class Solution541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k -1, length - 1);
            while (left < right) {
                chars[left] ^= chars[right];
                chars[right] ^= chars[left];
                chars[left] ^= chars[right];
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
