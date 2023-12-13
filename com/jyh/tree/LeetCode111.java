package com.jyh.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode111 {
    /**
     * 111. 二叉树的最小深度
     * leetcode url : https://leetcode.cn/problems/minimum-depth-of-binary-tree/
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {3,9,20,null,null,15,7};
        TreeNode root = TreeCreator.Create(nodeValArray);

    }

    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            int ans = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if(node.left == null && node.right == null){
                        return ans;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                ans++;
            }
            return ans; //为了防止报错而写在这的return，没啥实际逻辑
        }
    }
}
