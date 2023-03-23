package com.xin.quene.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hu·YX
 * @Description 239. 滑动窗口最大值
 * @Link <a href="https://leetcode.cn/problems/sliding-window-maximum/">239. 滑动窗口最大值</a>
 * @Date 2023/03/23
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 创建一个双端队列，用于存储可能成为滑动窗口最大值的元素下标
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] res = new int[n - k + 1];
        // 遍历数组中的元素
        for (int i = 0; i < n; i++) {
            // 如果队列不为空，且队列中最左边的元素已不再当前窗口内，则将其移除
            if (! deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 如果当前元素比队列中最右边元素大，则将队列中最右边元素移除，因为当前元素成为新的最大值
            while (! deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // 将当前元素加入队列
            deque.offerLast(i);
            // 如果当前窗口已经形成（窗口长度为k），则将队列中最左边的元素作为最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
