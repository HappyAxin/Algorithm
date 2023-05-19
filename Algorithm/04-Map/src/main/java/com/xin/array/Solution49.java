package com.xin.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description 49. 字母异位词分组
 * @Link <a href="https://leetcode.cn/problems/group-anagrams/">49. 字母异位词分组</a>
 * @Date 2023/03/06
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        // 遍历字符串数组 strs，对于每个字符串 s，使用一个长度为 26 的数组 count 统计其中字符出现的次数。
        for (String s : strs) {

            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // 将 count 数组转化为一个字符串 key，方法是遍历 count 数组，对于 count[i] 不为零的字符，将其 ASCII 码加上 'a' 后转化为字符，
            // 然后将该字符和 count[i] 拼接成字符串。例如 count = [2,0,1,0,1,0,...,0] 转化为字符串 "a2b1c1"。
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            // 如果 key 在哈希表 map 中不存在，则新建一个列表 list，并将 s 加入其中；否则，将 s 加入 map.get(key) 对应的列表中。
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            // 最终，哈希表 map 中的每个 value 就是一组字母异位词，将它们存入结果列表中即可
            list.add(s);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }
}
