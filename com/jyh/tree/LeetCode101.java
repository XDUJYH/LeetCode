package com.jyh.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode101 {
    /**
     * 101. 对称二叉树
     * leetcode url : https://leetcode.cn/problems/symmetric-tree/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0101.%E5%AF%B9%E7%A7%B0%E4%BA%8C%E5%8F%89%E6%A0%91.md
     * 和题解的第二种方法类似，不过题解的第一种方法是递归，有时间可以想想
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {1,2,2,3,4,4,3};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.isSymmetric(root));

    }

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root.left == null && root.right == null){
                return true;
            }
            if(root.left == null || root.right == null){
                return false;
            }
            LinkedList<TreeNode> leftTreeQueue = new LinkedList<>();
            LinkedList<TreeNode> rightTreeQueue = new LinkedList<>();
            leftTreeQueue.offer(root.left);
            rightTreeQueue.offer(root.right);
            while (!leftTreeQueue.isEmpty()||!rightTreeQueue.isEmpty()){
                TreeNode leftTreeNode = leftTreeQueue.poll();
                TreeNode rightTreeNode = rightTreeQueue.poll();
                if(leftTreeNode == null && rightTreeNode == null){
                    continue;
                }else if(leftTreeNode != null && rightTreeNode != null){
                    if (leftTreeNode.val == rightTreeNode.val){

                        leftTreeQueue.offer(leftTreeNode.left);
                        leftTreeQueue.offer(leftTreeNode.right);
                        rightTreeQueue.offer(rightTreeNode.right);
                        rightTreeQueue.offer(rightTreeNode.left);

                        continue;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
            return true;
        }
    }
}
