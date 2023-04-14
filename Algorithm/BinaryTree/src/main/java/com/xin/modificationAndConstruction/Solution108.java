package com.xin.modificationAndConstruction;

import com.xin.TreeNode;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">108. 将有序数组转换为二叉搜索树</a>
 * @Date 2023/04/14
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }
}
