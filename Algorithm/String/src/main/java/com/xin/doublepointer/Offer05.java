package com.xin.doublepointer;

import java.util.Arrays;

/**
 * @author Hu·YX
 * @Description 剑指 Offer 05. 替换空格
 * @Link <a href="https://leetcode.cn/problems/ti-huan-kong-ge-lcof/">剑指 Offer 05. 替换空格</a>
 * @Date 2023/03/09
 */
public class Offer05 {
    public String replaceSpace(String s) {
        // 将字符串转换为字符数组
        char[] charArray = s.toCharArray();
        int count = 0;
        for (char c : charArray) {
            if (c == ' ') {
                count++;
            }
        }
        // 扩展字符串数组长度，每个空格替换为“%20”需要额外的两个字符，所以长度增加2 * count
        int oldLength = charArray.length;
        int newLength = oldLength + 2 * count;
        charArray = Arrays.copyOf(charArray, newLength);
        // 从后往前遍历数组，进行替换
        int i = oldLength - 1;
        int j = newLength - 1;
        while (i >= 0) {
            // 如果当前字符是空格，将新数组指针往前移三位，依次填充“%20”
            if (charArray[i] == ' ') {
                charArray[j--] = '0';
                charArray[j--] = '2';
                charArray[j--] = '%';
            } else {
                // 如果当前字符不是空格，直接将其复制到新数组中
                charArray[j--] = charArray[i];
            }
            // 原数组之前后移
            i--;
        }
        return String.valueOf(charArray);
    }
}
