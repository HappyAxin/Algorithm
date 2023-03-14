package com.xin.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hu·YX
 * @Description 349. 两个数组的交集
 * @Link <a href="https://leetcode.cn/problems/intersection-of-two-arrays/">349. 两个数组的交集</a>
 * @Date 2023/03/06
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 如果nums1的长度大于nums2的长度，就交换
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }

        // 将较短的数组放入到Set中
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        // 遍历较长的数组，在Set中查找是否存在该元素
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                // 从Set中删除该元素，保证结果集中的元素唯一
                set.remove(num);
            }
        }

        // 将结果集转换为数组返回
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
