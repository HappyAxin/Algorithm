package com.xin.arrangement;

import java.util.*;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/reconstruct-itinerary/">332. 重新安排行程</a>
 * @Date 2023/05/16
 */
public class Solution332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        // 构建邻接表，将机场及其对应的目的地机场存储起来
        Map<String, PriorityQueue<String>> adjacencyList = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adjacencyList.putIfAbsent(from, new PriorityQueue<>());
            adjacencyList.get(from).offer(to);
        }

        List<String> itinerary = new ArrayList<>();
        dfs("JFK", adjacencyList, itinerary);
        // 反转行程，得到最小行程组合
        Collections.reverse(itinerary);

        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> adjacencyList, List<String> itinerary) {
        PriorityQueue<String> destinations = adjacencyList.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport, adjacencyList, itinerary);
        }
        itinerary.add(airport);
    }
}
