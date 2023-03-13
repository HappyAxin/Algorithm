package com.xin.binarysearch;

/**
 * @author Hu·YX
 * @Description 有效的完全平方数
 * @Link <a href="https://leetcode.cn/problems/valid-perfect-square/">367.有效的完全平方数</a>
 * @Date 2023/01/10
 */
public class Solution367 {
    public boolean isPerfectSquare(int num) {
        int low = 0, high = num;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (Math.pow(middle, 2) < num) {
                low = middle + 1;
            } else if (Math.pow(middle, 2) > num) {
                high = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
