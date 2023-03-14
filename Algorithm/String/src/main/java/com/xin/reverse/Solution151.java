package com.xin.reverse;

/**
 * @author Hu·YX
 * @Description 151. 反转字符串中的单词
 * @Link <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">151. 反转字符串中的单词</a>
 * @Date 2023/03/10
 */
public class Solution151 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        reverse(chars, 0, n - 1);
        int i = 0, j = 0;
        while (j < n) {
            // 跳过单词间的空格
            while (j < n && chars[j] == ' ') {
                j++;
            }
            i = j;
            // 找到下一个单词的末尾位置
            while (j < n && chars[j] != ' ') {
                j++;
            }
            // 反转当前单词
            reverse(chars, i, j - 1);
        }
        return cleanSpace(chars);
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

    private String cleanSpace(char[] chars) {
        int i = 0, j = 0;
        int n = chars.length;
        while (j < n) {
            // 跳过单词间的空格
            while (j < n && chars[j] == ' ') {
                j++;
            }
            // 复制当前单词
            while (j < n && chars[j] != ' ') {
                chars[i++] = chars[j++];
            }
            // 跳过单词末尾的空格
            while (j < n && chars[j] == ' ') {
                j++;
            }
            // 如果还有单词，添加一个空格
            if (j < n) {
                chars[i++] = ' ';
            }
        }
        return new String(chars, 0, i);
    }
}
