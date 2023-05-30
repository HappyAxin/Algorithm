package com.xin.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/">剑指 Offer 20. 表示数值的字符串</a>
 * @Date 2023/05/30
 */
public class Offer20 {
    public boolean isNumber(String s) {
        Map[] states = {
            new HashMap<Character, Integer>(4) {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }},
            new HashMap<Character, Integer>(2) {{ put('d', 2); put('.', 4); }},
            new HashMap<Character, Integer>(4) {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }},
            new HashMap<Character, Integer>(4) {{ put('d', 3); put('e', 5); put(' ', 8); }},
            new HashMap<Character, Integer>(1) {{ put('d', 3); }},
            new HashMap<Character, Integer>(2) {{ put('s', 6); put('d', 7); }},
            new HashMap<Character, Integer>(1) {{ put('d', 7); }},
            new HashMap<Character, Integer>(2) {{ put('d', 7); put(' ', 8); }},
            new HashMap<Character, Integer>(1) {{ put(' ', 8); }}
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                t = 'd';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else if (c == 'e' || c == 'E') {
                t = 'e';
            } else if (c == '.' || c == ',') {
                t = '.';
            } else if (c == ' ') {
                t = ' ';
            } else {
                t = '?';
            }
            if (! states[p].containsKey(t)) {
                return false;
            }
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
