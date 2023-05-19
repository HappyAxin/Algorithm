package com.xin.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hu·YX
 * @Description 202. 快乐数
 * @Link <a href="https://leetcode.cn/problems/happy-number/">202. 快乐数</a>
 * @Date 2023/03/07
 */
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }
        return n == 1;
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        while(n != 0) {
            int digit = n % 10;
            sum += Math.pow(digit, 2);
            n /= 10;
        }
        return sum;
    }
}
