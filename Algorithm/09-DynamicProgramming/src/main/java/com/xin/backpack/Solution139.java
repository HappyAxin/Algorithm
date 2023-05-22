package com.xin.backpack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/word-break/">139. 单词拆分</a>
 * @Date 2023/05/22
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i] 表示前 i 个字符是否可以拆分成字典中的单词
        boolean[] dp = new boolean[n + 1];
        // 空字符串可以拆分成字典中的单词，初始化为 true
        dp[0] = true;

        // 将字典中的单词存入哈希集合，方便查找
        Set<String> wordSet = new HashSet<>(wordDict);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果前 j 个字符可以拆分成字典中的单词，并且 j 到 i 的子串也在字典中
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    // 将 dp[i] 设置为 true，表示前 i 个字符可以拆分成字典中的单词
                    dp[i] = true;
                    break;
                }
            }
        }
        // 返回整个字符串是否可以拆分成字典中的单词
        return dp[n];
    }
}
