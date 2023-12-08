package com.jyh.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * leetcode url : https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 这是递归版本的中序遍历，注意官方题解的写法，我是将ans写在了solution的里面，而官方题解另外写了个函数用于递归
 */
public class LeetCode94Recursion {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        List<Integer> ans = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root == null){
                return ans;
            }
            inorderTraversal(root.left);
            ans.add(root.val);
            inorderTraversal(root.right);
            return ans;
        }
    }
}
