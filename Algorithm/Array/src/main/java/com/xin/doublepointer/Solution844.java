package com.xin.doublepointer;

/**
 * @author Hu·YX
 * @Description 比较含退格的字符串
 * @Link <a href="https://leetcode.cn/problems/backspace-string-compare/">844.比较含退格的字符串</a>
 * @Date 2023/01/10
 */
public class Solution844 {
    public static boolean backspaceCompare(String s, String t) {
        int sLength = s.length() - 1, tLength = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (sLength >= 0 || tLength >= 0) {
            while (sLength >= 0) {
                if (s.charAt(sLength) == '#') {
                    skipS++;
                    sLength--;
                } else if (skipS > 0) {
                    skipS--;
                    sLength--;
                } else {
                    break;
                }
            }
            while (tLength >= 0) {
                if (t.charAt(tLength) == '#') {
                    skipT++;
                    tLength--;
                } else if (skipT > 0) {
                    skipT--;
                    tLength--;
                } else {
                    break;
                }
            }
            if (sLength >= 0 && tLength >= 0) {
                if (s.charAt(sLength) != t.charAt(tLength)) {
                    return false;
                }
            } else {
                if (sLength >= 0 || tLength >= 0) {
                    return false;
                }
            }
            sLength--;
            tLength--;
        }
        return true;
    }
}
