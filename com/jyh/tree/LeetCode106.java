package com.jyh.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode106 {
    /**
     * 106. 从中序与后序遍历序列构造二叉树
     * leetcode url : https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0106.%E4%BB%8E%E4%B8%AD%E5%BA%8F%E4%B8%8E%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {1,2,3,4,null,5,6,null,null,7};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.findBottomLeftValue(root));

    }

    static class Solution {
        public int findBottomLeftValue(TreeNode root) {
            int ans = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    ans = node.val;
                    if (node.right != null){
                        queue.offer(node.right);
                    }
                    if (node.left != null){
                        queue.offer(node.left);
                    }
                }
            }
            return ans;
        }
    }
}
