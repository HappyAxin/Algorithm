package com.xin.binarysearch;

/**
 * @author Hu·YX
 * @Description x 的平方根
 * @Link <a href="https://leetcode.cn/problems/sqrtx/">69.x 的平方根</a>
 * @Date 2023/01/10
 */
public class Solution69 {
    public int mySqrt(int x) {
        int low = 0, high = x, ans = 0;
        while (low <= high) {
            int middle = low + (high - low) >> 1;
            if ((long)middle * middle <= x) {
                ans = middle;
                low = middle + 1;
            } else  {
                high = middle - 1;
            }
        }
        return ans;

    }
}
