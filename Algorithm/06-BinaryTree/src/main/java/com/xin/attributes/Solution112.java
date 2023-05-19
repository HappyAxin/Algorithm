package com.xin.attributes;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/path-sum/">112. 路径总和</a>
 * @Date 2023/04/13
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 如果根节点为空，则不存在符合要求的路径
        if (root == null) {
            return false;
        }
        // 如果当前节点为叶子节点，且值等于目标和，则存在符合要求的路径
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        // 对当前节点的左右子树分别进行递归搜索，搜索的目标值为目标和减去当前节点的值
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
