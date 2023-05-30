package com.xin.string;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof">剑指 Offer 67. 把字符串转换成整数</a>
 * @Date 2023/05/30
 */
public class Offer67 {
    public int strToInt(String str) {
        int i = 0, sign = 1, length = str.length();
        int result = 0;

        // 如果字符串为空，返回0
        if(length == 0) {
            return 0;
        }

        // 忽略前面的空格
        while(i < length && str.charAt(i) == ' ') {
            i++;
        }

        // 如果字符串只包含空格，则返回0
        if(i == length) {
            return 0;
        }

        // 检查第一个非空格字符是否为符号
        if(str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = (str.charAt(i++) == '-') ? -1 : 1;
        }

        // 转换数字
        while(i < length && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            // 检查是否越界
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + (str.charAt(i++) - '0');
        }

        return result * sign;
    }
}
