package com.jyh.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode515 {
    /**
     * 515. 在每个树行中找最大值
     * leetcode url : https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {1,3,2,5,3,null,9};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.largestValues(root));

    }

    static class Solution {
        public List<Integer> largestValues(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            if(root == null){
                return result;
            }
            int size;
            Integer max;
            queue.offer(root);
            while (!queue.isEmpty()){
                size = queue.size();
                max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.val > max){
                        max = node.val;
                    }
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
                result.add(max);
            }
            return result;
        }
    }
}
