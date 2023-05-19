package com.xin.medium.balance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/queue-reconstruction-by-height/">406. 根据身高重建队列</a>
 * @Date 2023/05/18
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        // 按照身高降序排序，如果身高相同则按照ki升序排序
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return b[0] - a[0];
                }
            }
        });
        List<int[]> queue = new ArrayList<>();
        // 根据ki插入到相应位置
        for (int[] person : people) {
            queue.add(person[1], person);
        }

        // 将List转换为二维数组
        int[][] reconstructedQueue = new int[people.length][2];
        for (int i = 0; i < queue.size(); i++) {
            reconstructedQueue[i] = queue.get(i);
        }

        return reconstructedQueue;
    }
}
