package com.jyh.tree;

import java.util.*;

public class LeetCode637 {
    /**
     * 637. 二叉树的层平均值
     * leetcode url : https://leetcode.cn/problems/average-of-levels-in-binary-tree/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {3,9,20,null,null,15,7};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.averageOfLevels(root));

    }

    static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            List<Double> result = new ArrayList<>();
            if(root == null){
                return result;
            }
            int size;
            queue.offer(root);
            while (!queue.isEmpty()){
                Double sum = 0.0;
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
                result.add(sum/size);
            }
            return result;
        }
    }
}
