package com.xin.quene.priority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description 347. 前 K 个高频元素
 * @Link <a href="https://leetcode.cn/problems/top-k-frequent-elements/">347. 前 K 个高频元素</a>
 * @Date 2023/03/23
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 统计每个元素出现的频率
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 创建k个桶，将相同频率的元素放入同一个桶中
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        // 从后往前遍历，按照从大到小的顺序取出桶中的元素，直到取出第k个元素为止
        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    res[index++] = num;
                    if (index == k) {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
