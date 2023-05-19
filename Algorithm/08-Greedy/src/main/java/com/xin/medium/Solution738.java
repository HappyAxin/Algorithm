package com.xin.medium;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/monotone-increasing-digits/">738. 单调递增的数字</a>
 * @Date 2023/05/18
 */
public class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int length = digits.length;
        // 标记需要修改的位置
        int marker = length;
        // 从右向左找到第一个不满足单调递增的位置
        for (int i = length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                marker = i - 1;
                // 修改为当前位数减1
                digits[i - 1]--;
            }
        }

        // 将标记位置及其右侧的所有位数修改为9，使得满足最大单调递增
        for (int i = marker + 1; i < length; i++) {
            digits[i] = '9';
        }

        return Integer.parseInt(new String(digits));
    }
}
