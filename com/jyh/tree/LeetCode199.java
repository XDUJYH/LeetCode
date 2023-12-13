package com.jyh.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode199 {
    /**
     * 199. 二叉树的右视图
     * leetcode url : https://leetcode.cn/problems/binary-tree-right-side-view/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {1,2,3,null,5,null,4};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.rightSideView(root));

    }

    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            int size;
            queue.offer(root);
            while (!queue.isEmpty()){
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                    if(i == size -1){
                        result.add(node.val);
                    }
                }
            }
            return result;
        }
    }
}
