package com.jyh.tree;

import java.util.LinkedList;

public class LeetCode222 {
    /**
     * 222. 完全二叉树的节点个数
     * leetcode url : https://leetcode.cn/problems/count-complete-tree-nodes/description/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0222.%E5%AE%8C%E5%85%A8%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E8%8A%82%E7%82%B9%E4%B8%AA%E6%95%B0.md
     * 思路是对于一个没填满的完全二叉树而言，其节点的左子树和右子树只有一个是没填满的完全二叉树，而填满的完全二叉树的结点数量可以根据深度直接计算得出，因此可以采取递归，对未填满的完全二叉树，每次都将其分成一个填满的二叉树和一个未填满完全二叉树，进行递归计算。
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.countNodes(root));

    }

    static class Solution {
        public int countNodes(TreeNode root) {
            if(root == null){
                return 0;
            }
            if(root.left == null && root.right == null){
                return 1;
            }
            if(root.left != null && root.right == null){
                return 2;
            }
            if(leftDepth(root) == rightDepth(root)){
                return (int) Math.pow(2, leftDepth(root)) - 1;
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }

        public int leftDepth(TreeNode root){
            if(root == null){
                return 0;
            }
            return leftDepth(root.left) + 1;
        }
        public int rightDepth(TreeNode root){
            if(root == null){
                return 0;
            }
            return rightDepth(root.right) + 1;
        }
    }
}
