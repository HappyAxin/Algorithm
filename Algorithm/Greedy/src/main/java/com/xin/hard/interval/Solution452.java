package com.xin.hard.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/">452. 用最少数量的箭引爆气球</a>
 * @Date 2023/05/18
 */
public class Solution452 {
    /**
     * <p>有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。</p>
     * <p>一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。</p>
     * <p>给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。</p>
     *
     * @param points 目标数组
     * @return int
     */
    public int findMinArrowShots(int[][] points) {
        // 按照气球的结束坐标进行升序排序
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Long.compare((long) a[1], (long) b[1]);
            }
        });

        // 记录弓箭的数量
        int count = 0;
        // 记录当前弓箭的射出位置
        long end = Long.MIN_VALUE;

        for (int[] point : points) {
            if ((long) point[0] > end) {
                // 当前气球的开始坐标大于当前弓箭的射出位置，需要射出一支新的弓箭
                count++;
                // 更新弓箭的射出位置
                end = (long) point[1];
            }
        }

        return count;
    }
}
