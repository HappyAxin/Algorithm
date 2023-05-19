package com.xin.set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description 350. 两个数组的交集 II
 * @Link <a href="https://leetcode.cn/problems/intersection-of-two-arrays-ii/">350. 两个数组的交集 II</a>
 * @Date 2023/03/07
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 将较短的数组放入Map中，key为元素，value为出现的次数
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        // 遍历较长的数组，在map中查找是否存在该元素
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                list.add(num);
                map.put(num, count - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
