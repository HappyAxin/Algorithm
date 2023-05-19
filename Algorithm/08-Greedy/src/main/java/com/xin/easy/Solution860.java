package com.xin.easy;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/lemonade-change/">860. 柠檬水找零</a>
 * @Date 2023/05/18
 */
public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        // 5美元的数量
        int fiveCount = 0;
        // 10美元的数量
        int tenCount = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                if (fiveCount == 0) {
                    // 没有足够的5美元可以找零
                    return false;
                }
                fiveCount--;
                tenCount++;
            } else if (bill == 20) {
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    // 没有足够的5美元和10美元可以找零
                    return false;
                }
            }
        }

        return true;
    }
}
