package com.xin.modificationAndConstruction;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/maximum-binary-tree/">654. 最大二叉树</a>
 * @Date 2023/04/13
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maxIndex = left;
        // 找到 nums 中的最大值
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        // 创建根节点，值为 nums 中的最大值
        TreeNode root = new TreeNode(nums[maxIndex]);
        // 递归地在最大值左边的子数组前缀上构建左子树
        root.left = construct(nums, left, maxIndex - 1);
        // 递归地在最大值右边的子数组后缀上构建右子树
        root.right = construct(nums, maxIndex + 1, right);
        return root;
    }
}
