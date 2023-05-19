package com.xin.hard.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/merge-intervals/">56. 合并区间</a>
 * @Date 2023/05/18
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        // 按区间的起始位置进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 存储合并后的区间
        List<int[]> mergedIntervals = new ArrayList<>();
        // 当前区间
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                // 当前区间与下一个区间有重叠，更新当前区间的结束位置
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // 当前区间与下一个区间没有重叠，将当前区间加入合并后的区间列表，并更新当前区间为下一个区间
                mergedIntervals.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // 将最后一个区间加入合并后的区间列表
        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
