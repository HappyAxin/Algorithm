package com.xin.partition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/restore-ip-addresses/">93. 复原IP地址</a>
 * @Date 2023/04/25
 */
public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<String> result, List<String> temp, String s, int start) {
        // 如果已经找到了4段IP地址且已经扫描完整个字符串，则将当前中间结果加入到最终结果中
        if (temp.size() == 4 && start == s.length()) {
            result.add(String.join(".", temp));
            return;
        }
        // 如果已经找到了4段IP地址但还没扫描完整个字符串，则直接返回
        if (temp.size() == 4) {
            return;
        }
        // 枚举所有可能的IP地址段，并继续向后搜索
        for (int i = start; i < s.length(); i++) {
            String segment = s.substring(start, i + 1);
            // IP地址段不能有前导0，不能超过255，如果满足条件则将其加入到中间结果中，并继续搜索下一段
            if (isValid(segment)) {
                temp.add(segment);
                backtrack(result, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    /**
     * 判断IP地址段是否合法
     *
     * @param segment IP段
     * @return boolean
     */
    private boolean isValid(String segment) {
        // IP地址段长度不能超过3
        if (segment.length() > 3) {
            return false;
        }
        // IP地址段不能以0开头，除非它本身就是0
        if (segment.startsWith("0") && segment.length() > 1) {
            return false;
        }
        // IP地址段必须小于等于255
        if (Integer.parseInt(segment) > 255) {
            return false;
        }
        return true;
    }
}
