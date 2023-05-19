package com.xin.hard.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/non-overlapping-intervals/">435. 无重叠区间</a>
 * @Date 2023/05/18
 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 对区间按照结束位置进行升序排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        // 记录需要移除的区间数量
        int count = 0;
        // 记录当前区间的结束位置
        int end = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                // 当前区间的开始位置大于等于前一个区间的结束位置，不重叠
                // 更新当前区间的结束位置
                end = interval[1];
            } else {
                // 当前区间和前一个区间重叠，需要移除当前区间
                // 移除区间数量加一
                count++;
            }
        }

        return count;
    }
}
