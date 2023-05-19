package com.xin.medium.balance;

import java.util.Arrays;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/candy/">135. 分发糖果</a>
 * @Date 2023/05/18
 */
public class Solution135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        // 存储每个孩子分配的糖果数
        int[] candies = new int[n];

        // 初始化每个孩子的糖果数为1
        Arrays.fill(candies, 1);

        // 从左到右遍历，保证右边评分更高的孩子获得更多的糖果
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 从右到左遍历，处理左边评分更高的孩子获得更多的糖果的情况
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // 计算总的糖果数
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }
}
