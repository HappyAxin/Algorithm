package com.xin.subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/is-subsequence/">392. 判断子序列</a>
 * @Date 2023/05/26
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        // 存储字符在 T 中的位置索引
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        // 构建索引
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            indexMap.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }
        // 记录前一个匹配的位置
        int prevIndex = - 1;
        // 检查是否为子序列
        for (char ch : s.toCharArray()) {
            if (! indexMap.containsKey(ch)) {
                // 字符 ch 不在 T 中，无法匹配子序列
                return false;
            }
            List<Integer> indices = indexMap.get(ch);
            int pos = binarySearch(indices, prevIndex + 1);
            if (pos == indices.size()) {
                // 无法找到下一个匹配位置
                return false;
            }
            // 更新前一个匹配的位置
            prevIndex = indices.get(pos);
        }
        return true;
    }

    /**
     * 二分查找，查找大于等于 target 的最小值所在的位置
     *
     * @param nums   目标List
     * @param target 目标
     * @return int
     */
    private static int binarySearch(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums.get(mid);
            if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
