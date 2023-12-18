package com.jyh.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode257Q {
    /**
     * 257. 二叉树的所有路径
     * leetcode url : https://leetcode.cn/problems/binary-tree-paths/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0257.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%89%80%E6%9C%89%E8%B7%AF%E5%BE%84.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {1,2,3,null,5};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.binaryTreePaths(root));

    }

    static class Solution {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return null;
        String str = String.valueOf(root.val);
        if(root.left == null || root.right == null){
            res.add(str);
            return res;
        }
        if (root.left == null) {
            process(str,root.right);
        }

        if (root.right == null) {
            process(str,root.left);
        }
        if(root.right != null || root.left != null){
            process(str,root.left);
            process(str,root.right);
        }
        return res;
    }
    public void process(String str, TreeNode treeNode){
        if(treeNode.left == null || treeNode.right == null){
            str = str + "->" + String.valueOf(treeNode.val);
            res.add(str);
        }
        if (treeNode.left == null) {
            str = str + "->" + String.valueOf(treeNode.val);
            process(str,treeNode.right);
        }

        if (treeNode.right == null) {
            str = str + "->" + String.valueOf(treeNode.val);
            process(str,treeNode.left);
        }
        if(treeNode.right != null || treeNode.left != null){
            str = str + "->" + String.valueOf(treeNode.val);
            process(str,treeNode.left);
            process(str,treeNode.right);
        }
    }

    }
}