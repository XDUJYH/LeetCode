package com.jyh.tree;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode429 {
    /**
     * 429. N 叉树的层序遍历
     * leetcode url : https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        public List<List<Integer>> levelOrder(Node_1 root) {
            LinkedList<Node_1> queue = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            if(root == null){
                return result;
            }
            queue.offer(root);
            int size;
            while (!queue.isEmpty()){
                size = queue.size();
                List<Integer> tempt = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Node_1 node = queue.poll();
                    tempt.add(node.val);
                    for (int j = 0; j < node.children.size(); j++) {
                        if(node.children.get(j) != null){
                            queue.offer(node.children.get(j));
                        }
                    }
                }
                result.add(tempt);
            }
            return result;
        }
    }
}
