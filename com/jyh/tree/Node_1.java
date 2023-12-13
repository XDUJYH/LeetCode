package com.jyh.tree;


import java.util.List;

public class Node_1 {
    public int val;
    public List<Node_1> children;

    public Node_1() {}

    public Node_1(int _val) {
        val = _val;
    }

    public Node_1(int _val, List<Node_1> _children) {
        val = _val;
        children = _children;
    }
};