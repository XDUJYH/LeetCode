package com.jyh.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode116 {
    /**
     * 116. 填充每个节点的下一个右侧节点指针
     * leetcode url : https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {3,9,20,null,null,15,7};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1);

    }

    static class Solution {
        public Node connect(Node root) {
            LinkedList<Node> queue = new LinkedList<>();
            List<Double> result = new ArrayList<>();
            if(root == null){
                return root;
            }
            int size;
            queue.offer(root);
            while (!queue.isEmpty()){
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if(i != size - 1){
                        node.next = queue.peek();
                    }else {
                        node.next = null;
                    }
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }
    }
}
