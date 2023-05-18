package com.xin.hard.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/partition-labels/">763. 划分字母区间</a>
 * @Date 2023/05/18
 */
public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        // 记录每个字母最后出现的位置
        int[] lastIndices = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 更新字母的最后出现位置
            lastIndices[s.charAt(i) - 'a'] = i;
        }

        // 存储每个片段的长度
        List<Integer> partitions = new ArrayList<>();
        // 当前片段的起始位置
        int start = 0;
        // 当前片段的结束位置
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // 更新当前片段的结束位置
            end = Math.max(end, lastIndices[s.charAt(i) - 'a']);
            // 当前位置为当前片段的结束位置
            if (i == end) {

                // 将当前片段的长度加入结果列表
                partitions.add(end - start + 1);
                // 更新下一个片段的起始位置
                start = end + 1;
            }
        }

        return partitions;
    }
}
