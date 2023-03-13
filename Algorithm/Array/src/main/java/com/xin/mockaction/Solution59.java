package com.xin.mockaction;

/**
 * @author Hu·YX
 * @Description 螺旋矩阵 II
 * @Link <a href="https://leetcode.cn/problems/spiral-matrix-ii/">59.螺旋矩阵 II</a>
 * @Date 2023/01/11
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        // 控制循环次数
        int loop = 0;
        int[][] res = new int[n][n];
        // 每次循环的开始点(start, start)
        int start = 0;
        // 定义填充数字
        int count = 1;
        int i, j;

        // 判断边界后，loop从1开始
        while (loop++ < n / 2) {
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }
        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;
    }
}
