package com.jyh.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode113 {
    /**
     * 113. 路径总和 II
     * leetcode url : https://leetcode.cn/problems/path-sum-ii/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0112.%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.md
     * 跟题解基本一致，不过题解把两个path, result这两个变量提到了类成员变量，使得遍历的时候就不用传入这两个参数了，明显让代码更简洁了。
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        int targetSum = 22;
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.pathSum(root, targetSum));

    }

    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();
            if(root == null){
                return result;
            }
            path(root, targetSum, path, result);
            return result;
        }
        public void path(TreeNode node, int target, LinkedList<Integer> path, List<List<Integer>> result){
            if(node.left == null && node.right == null){
                path.offerLast(node.val);
                if(node.val == target){
                    result.add(new ArrayList<>(path));
                }
                path.pollLast();
            }

            path.offerLast(node.val);
            if(node.left != null){
                path(node.left, target - node.val, path, result);
            }
            if(node.right != null){
                path(node.right, target - node.val, path, result);
            }
            path.pollLast();
        }
    }
}