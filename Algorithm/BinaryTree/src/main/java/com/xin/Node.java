package com.xin;

import java.util.List;

/**
 * @author Hu·YX
 * @Description 节点
 * @Date 2023/03/27
 */
public class Node {

    public int val;

    public List<Node> children;

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
