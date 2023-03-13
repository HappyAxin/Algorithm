package com.xin.mockaction;

/**
 * @author Hu·YX
 * @Description 顺时针打印矩阵
 * @Link <a href="https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/">剑指 Offer 29. 顺时针打印矩阵</a>
 * @Date 2023/03/03
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int x = 0;

        int[] res = new int[(right + 1) * (bottom + 1)];

        while (true) {
            // 从左到右, 列变，列循环
            for (int i = left; i <= right; i++) {
                res[x++] = matrix[top][i];
            }
            // 下一步是往下走，上边界收缩，故++top
            if (++top > bottom) {
                break;
            }
            // 从上到下，行变，行循环
            for (int i = top; i <= bottom; i++) {
                res[x++] = matrix[i][right];
            }
            // 下一步是往左走，右边界收缩，--right
            if (--right < left) {
                break;
            }
            // 从右到左，列变，列循环
            for (int i = right; i >= left; i--) {
                res[x++] = matrix[bottom][i];
            }
            // 下一步是往上走，下边界收缩，--bottom
            if (top > --bottom) {
                break;
            }
            // 从下到上，行变，行循环
            for (int i = bottom; i >= top; i--) {
                res[x++] = matrix[i][left];
            }
            // 下一步是往右走，左边界收缩，++left
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
