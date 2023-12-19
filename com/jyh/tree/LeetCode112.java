package com.jyh.tree;

import java.util.LinkedList;
import java.util.List;

public class LeetCode112 {
    /**
     * 112. 路径总和
     * leetcode url : https://leetcode.cn/problems/path-sum/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0112.%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.md
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        int targetSum = 22;
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.hasPathSum(root, targetSum));

    }

    static class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root != null){
                if(root.val == targetSum && root.left == null && root.right == null){
                    return true;
                }
            }else {
                return false;
            }
            return hasPathSum(root.left, targetSum - root.val)||hasPathSum(root.right, targetSum - root.val);
        }
    }
}