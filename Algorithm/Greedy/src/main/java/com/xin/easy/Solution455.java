package com.xin.easy;

import java.util.Arrays;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/assign-cookies/">455. 分发饼干</a>
 * @Date 2023/05/16
 */
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        // 首先对孩子的胃口值和饼干的尺寸进行排序
        Arrays.sort(g);
        Arrays.sort(s);

        // 记录满足胃口的孩子数量
        int contentChildren = 0;
        // 孩子指针
        int i = 0;
        // 饼干指针
        int j = 0;

        // 遍历孩子和饼干，尽可能满足更多数量的孩子
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                // 饼干满足孩子的胃口，孩子数量加一
                contentChildren++;
                // 移动到下一个孩子
                i++;
            }
            // 不论是否满足孩子，都需要尝试下一块饼干
            j++;
        }

        return contentChildren;
    }
}
