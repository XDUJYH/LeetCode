package com.jyh.tree;

import java.util.LinkedList;
import java.util.List;

public class LeetCode437 {
    /**
     * 437. 路径总和 III
     * leetcode url : https://leetcode.cn/problems/path-sum-iii/
     * 只能说非常巧妙。涉及前缀和和哈希表的使用，并且如何使用也非常具有细节。
     *
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {10,5,-3,3,2,null,11,3,-2,null,1};
        int targetSum = 8;
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.pathSum(root, targetSum));

    }

    static class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }

            int ret = rootSum(root, targetSum);
            ret += pathSum(root.left, targetSum);
            ret += pathSum(root.right, targetSum);
            return ret;
        }

        public int rootSum(TreeNode root, int targetSum) {
            int ret = 0;

            if (root == null) {
                return 0;
            }
            int val = root.val;
            if (val == targetSum) {
                ret++;
            }

            ret += rootSum(root.left, targetSum - val);
            ret += rootSum(root.right, targetSum - val);
            return ret;
        }
    }
}

