package com.jyh.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * leetcode url : https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 * 这是递归版本的前序遍历，注意官方题解的写法，我是将ans写在了solution的里面，而官方题解另外写了个函数用于递归
 */
public class LeetCode144Recursion {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        List<Integer> ans = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if(root == null){
                return ans;
            }
            ans.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return ans;
        }
    }
}
