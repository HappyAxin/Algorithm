package com.xin.mockaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description 螺旋矩阵
 * @Link <a href="https://leetcode.cn/problems/spiral-matrix/">54.螺旋矩阵</a>
 * @Date 2023/01/11
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>(0);
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        ArrayList<Integer> res = new ArrayList<>((right + 1) * (bottom + 1));

        while (true) {
            // 从左到右, 列变，列循环
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            // 下一步是往下走，上边界收缩，故++top
            if (++top > bottom) {
                break;
            }
            // 从上到下，行变，行循环
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            // 下一步是往左走，右边界收缩，--right
            if (--right < left) {
                break;
            }
            // 从右到左，列变，列循环
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            // 下一步是往上走，下边界收缩，--bottom
            if (top > --bottom) {
                break;
            }
            // 从下到上，行变，行循环
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            // 下一步是往右走，左边界收缩，++left
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
