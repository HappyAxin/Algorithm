package com.xin.reverse;

/**
 * @author Hu·YX
 * @Description 剑指 Offer 58 - II. 左旋转字符串
 * @Link <a href="https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/">剑指 Offer 58 - II. 左旋转字符串</a>
 * @Date 2023/03/10
 */
public class Offer58II {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        // 防止n大于字符串的长度
        n = n % length;
        // 反转前面的部分
        reverse(chars, 0, n - 1);
        // 反转后面的部分
        reverse(chars, n, length - 1);
        // 反转整个字符串
        reverse(chars, 0, length - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
            i++;
            j--;
        }
    }
}
