package com.xin.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description 454. 四数相加 II
 * @Link <a href="https://leetcode.cn/problems/4sum-ii/">454. 四数相加 II</a>
 * @Date 2023/03/07
 */
public class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        // 将nums1和nums2中所有可能的和的出现次数存入map中
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        // 查找nums3和nums4中所有可能的和的相反数是否在map中出现过
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int sum = num3 + num4;
                count += map.getOrDefault(-sum, 0);
            }
        }
        return count;
    }
}
