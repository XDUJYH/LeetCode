package com.jyh.tree;

import java.util.LinkedList;
import java.util.List;

public class LeetCode437 {
    /**
     * 437. 路径总和 III
     * leetcode url : https://leetcode.cn/problems/path-sum-iii/
     *
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {10,5,-3,3,2,null,11,3,-2,null,1};
        int targetSum = 8;
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.pathSum(root, targetSum));

    }

    static class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            int sum = 0;
            List<LinkedList<Integer>> paths = new LinkedList<>();
            LinkedList<Integer> queue = new LinkedList<>();
            getPaths(root, paths, queue);
            for (int i = 0; i < paths.size() - 1; i++) {
                for(int j = i + 1; j < paths.size() ; j++){

                }

            }
            return 0;
        }
        public void getPaths (TreeNode root, List<LinkedList<Integer>> paths, LinkedList<Integer> dequeue){
            //到达叶子节点，存储这条路径
            if(root.left == null && root.right == null){
                dequeue.offerLast(root.val);
                paths.add(new LinkedList<>(dequeue));
                dequeue.pollLast();
                return ;
            }
            dequeue.offerLast(root.val);
            if(root.left!=null){
                getPaths(root.left, paths, dequeue);
            }
            if(root.right!=null){
                getPaths(root.right, paths, dequeue);
            }
            dequeue.pollLast();
            return ;
        }
    }
}
