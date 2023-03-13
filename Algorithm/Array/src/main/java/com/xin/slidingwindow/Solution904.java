package com.xin.slidingwindow;

/**
 * @author Hu·YX
 * @Description 水果成篮
 * @Link <a href="https://leetcode.cn/problems/fruit-into-baskets/">904.水果成篮</a>
 * @Date 2023/01/10
 */
public class Solution904 {
    /**
     * 只包含两种元素的最长子串的长度
     *
     * @param fruits 目标数组
     * @return int
     */
    public int totalFruit(int[] fruits) {
        int now = fruits[0], pre = -1, max = 0, nowStart = 0, preStart = 0;
        for (int i = 1; i < fruits.length; i++) {
            int fruit = fruits[i];
            // 每次都将当前的元素与前两个比
            if (now != fruit) {
                // 当前元素和往前一个元素的值不同，相同就不用管
                if (pre != fruit) {
                    // 当前元素的值和往前两个元素的值不同，相同就不用管
                    if (pre != -1) {
                        max = Math.max(max, i - preStart);
                        preStart = nowStart;
                    }
                }
                pre = now;
                now = fruit;
                nowStart = i;
            }
        }
        return Math.max(max, fruits.length - preStart);
    }
}
