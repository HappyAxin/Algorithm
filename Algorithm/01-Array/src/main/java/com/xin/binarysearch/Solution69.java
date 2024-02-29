package com.xin.binarysearch;

/**
 * @author Hu·YX
 * @Description x 的平方根
 * @Link <a href="https://leetcode.cn/problems/sqrtx/">69.x 的平方根</a>
 * @Date 2023/01/10
 */
public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 定义二分查找的左右边界
        long left = 1, right = x;
        while (left < right) {
            // 计算中点，这里采用left + (right - left + 1) / 2来防止溢出
            // 并且这样计算可以让mid偏向右边，便于处理边界情况
            long mid = left + (right - left + 1) / 2;
            if (mid * mid > x) {
                // 如果mid的平方大于x，说明真正的平方根在左边，调整right的值
                right = mid - 1;
            } else {
                // 否则，平方根在右边，调整left的值
                left = mid;
            }
        }
        // 循环结束后，left就是x的平方根的整数部分
        return (int)left;
    }
}
