package com.xin.attributes;

import com.xin.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hu·YX
 * @Description <a href="https://leetcode.cn/problems/binary-tree-paths/">257. 二叉树的所有路径</a>
 * @Date 2023/04/06
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, new StringBuilder(), res);
        return res;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> res) {
        // 将当前节点加入路径中
        path.append(node.val);
        // 如果当前节点是叶子节点，则将该路径加入结果集
        if (node.left == null && node.right == null) {
            res.add(path.toString());
        } else {
            // 如果不是叶子节点则继续遍历左右子树
            path.append("->");
            if (node.left != null) {
                dfs(node.left, new StringBuilder(path), res);
            }
            if (node.right != null) {
                dfs(node.right, new StringBuilder(path), res);
            }
        }
    }
}
