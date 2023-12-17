package com.jyh.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode110 {
    /**
     * 110. 平衡二叉树
     * leetcode url : https://leetcode.cn/problems/balanced-binary-tree/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0110.%E5%B9%B3%E8%A1%A1%E4%BA%8C%E5%8F%89%E6%A0%91.md
     * 第一次写的是自顶向下的遍历，时间复杂度太高了！二刷的时候记得再写一次，要求自底向上遍历，这样时间复杂度只要n！要学会灵活使用递归。
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {1,2,2,3,3,null,null,4,4};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.isBalanced(root));

    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            if(Math.abs(leftDepth - rightDepth) > 1){
                return false;
            }
            return isBalanced(root.left)&&isBalanced(root.right);
        }
        public int getDepth(TreeNode root){
            if(root == null){
                return 0;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            int depth = 0;
            int size;
            queue.offer(root);
            while (!queue.isEmpty()){
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
                depth++;
            }
            return depth;
        }
        //这是递归版本的获取树的高度的算法
        public int getDepthImprove(TreeNode root){
            if (root == null){
                return 0;
            }
            return Math.max(getDepthImprove(root.left),getDepthImprove(root.right)) + 1;
        }
        //接下来是最优解，时间复杂度比上一个方法好多了
        public boolean isBalancedImprove(TreeNode root){
            return height(root)>-1;
        }
        public int height(TreeNode root){
            if (root == null){
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
                return -1;
            }
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
}
