package com.xin.hard.other;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/gas-station/">134. 加油站</a>
 * @Date 2023/05/18
 */
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 总的剩余汽油量
        int totalGas = 0;
        // 当前剩余汽油量
        int currentGas = 0;
        // 起始加油站的编号
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            // 计算总的剩余汽油量
            totalGas += gas[i] - cost[i];
            // 计算当前剩余汽油量
            currentGas += gas[i] - cost[i];

            // 如果当前剩余汽油量小于0，表示无法从当前加油站前往下一个加油站
            // 需要将起始加油站设置为下一个加油站，并将当前剩余汽油量重置为0
            if (currentGas < 0) {
                startStation = i + 1;
                currentGas = 0;
            }
        }
        // 如果总的剩余汽油量大于等于0，表示可以绕环路行驶一周
        // 返回起始加油站的编号
        // 否则，返回-1
        return totalGas >= 0 ? startStation : - 1;
    }
}
