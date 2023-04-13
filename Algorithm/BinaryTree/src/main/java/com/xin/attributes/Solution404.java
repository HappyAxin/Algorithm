package com.xin.attributes;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/sum-of-left-leaves/">404. 左叶子之和</a>
 * @Date 2023/04/13
 */
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            // 如果根节点为空，则返回0
            return 0;
        }
        // 初始化左叶子节点的和为0
        int sum = 0;
        // 如果左子树不为空
        if (root.left != null) {
            // 如果左子树的左右节点都为空，则左子树时左叶子节点
            if (root.left.left == null && root.left.right == null) {
                // 将左叶子节点的值加入到和中
                sum += root.left.val;
            } else {
                // 否则递归遍历左子树
                sum += sumOfLeftLeaves(root.left);
            }
        }
        // 递归遍历右子树
        sum += sumOfLeftLeaves(root.right);
        // 返回左叶子节点的和
        return sum;
    }
}
