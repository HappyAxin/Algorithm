package com.xin.combination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">17. 电话号码的字母组合</a>
 * @Date 2023/04/17
 */
public class Solution17 {

    private static final Map<Character, String> map = new HashMap<>(8);
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder cur = new StringBuilder();
        backtrack(res, cur, digits, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder cur, String digits, int start) {
        // 如果已经处理完所有数字，就将当前生成的字符串加入结果列表
        if (cur.length() == digits.length()) {
            res.add(cur.toString());
            return;
        }
        // 取出当前数字对应的所有字母
        String letters = map.get(digits.charAt(start));
        for (int i = 0; i < letters.length(); i++) {
            // 将当前字母添加到字符串末尾
            cur.append(letters.charAt(i));
            // 递归搜索下去
            backtrack(res, cur, digits, start + 1);
            // 回溯，撤销上一步操作
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
