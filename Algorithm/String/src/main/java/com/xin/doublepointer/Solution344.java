package com.xin.doublepointer;

/**
 * @author Hu·YX
 * @Description 344. 反转字符串
 * @Link <a href="https://leetcode.cn/problems/reverse-string/">344. 反转字符串</a>
 * @Date 2023/03/09
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}
