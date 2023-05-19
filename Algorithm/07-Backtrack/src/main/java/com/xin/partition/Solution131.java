package com.xin.partition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/palindrome-partitioning/">131. 分割回文串</a>
 * @Date 2023/04/25
 */
public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    /**
     * 回溯搜索函数
     *
     * @param result 最终结果
     * @param temp   中间结果
     * @param s      原始字符串
     * @param start  当前搜索起始位置
     */
    private void backtrack(List<List<String>> result, List<String> temp, String s, int start) {
        // 如果搜索到了字符串的末尾，则将当前的中间结果加入到最终结果中，并返回
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // 枚举所有可能的回文串，并继续向后搜索
        for (int i = start; i < s.length(); i++) {
            // 如果s从start到i位置的子串是回文串，则将其加入到中间结果中，并继续搜索
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                backtrack(result, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    /**
     * 判断s从start到end位置的子串是否为回文串
     *
     * @param s     字符串
     * @param start 起始位置
     * @param end   终止位置
     * @return boolean
     */
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
