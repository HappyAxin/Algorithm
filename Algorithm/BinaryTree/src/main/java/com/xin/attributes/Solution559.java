package com.xin.attributes;

import com.xin.Node;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/">559. N 叉树的最大深度</a>
 * @Date 2023/04/06
 */
public class Solution559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxChildDepth = 0;
        for (Node child : root.children) {
            int childDepth = maxDepth(child);
            if (childDepth > maxChildDepth) {
                maxChildDepth = childDepth;
            }
        }
        return maxChildDepth + 1;
    }
}
