package com.xin.modificationAndConstruction;

import com.xin.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106. 从中序与后序遍历序列构造二叉树</a>
 * @Date 2023/04/13
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 判断输入的中序遍历数组和后序遍历数组是否为空或长度是否一致
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        // 构建哈希表，用于快速查找中序遍历数组中节点的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // 调用递归函数构建二叉树
        return buildTreeHelper(inorder, postorder, map, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, Map<Integer, Integer> map,
                                     int inStart, int inEnd, int postStart, int postEnd) {
        // 如果中序遍历数组和后序遍历数组为空，则返回null
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        // 后序遍历数组的最后一个元素即为根节点
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        // 获取根节点在中序遍历数组中的位置
        int rootIndex = map.get(rootVal);
        // 计算左子树中的节点数
        int leftSize = rootIndex - inStart;
        // 递归构建左子树
        root.left = buildTreeHelper(inorder, postorder, map, inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        // 递归构建右子树
        root.right = buildTreeHelper(inorder, postorder, map, rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
        return root;
    }
}
