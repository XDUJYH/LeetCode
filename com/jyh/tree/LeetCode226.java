package com.jyh.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode226 {
    /**
     * 226. 翻转二叉树
     * leetcode url : https://leetcode.cn/problems/invert-binary-tree/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0226.%E7%BF%BB%E8%BD%AC%E4%BA%8C%E5%8F%89%E6%A0%91.md
     * 我用的层序遍历的思想解决的，不过题解用的递归，下次复习这题记得用递归试试
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {3,9,20,null,null,15,7};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.invertTree(root));

    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return root;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                swap(node);
            }
            return root;
        }
        public void swap(TreeNode root){
            TreeNode tempt = root.left;
            root.left = root.right;
            root.right = tempt;
        }
    }
}
