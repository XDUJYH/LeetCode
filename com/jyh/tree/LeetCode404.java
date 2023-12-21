package com.jyh.tree;

import java.util.LinkedList;

public class LeetCode404 {
    /**
     * 404. 左叶子之和
     * leetcode url : https://leetcode.cn/problems/sum-of-left-leaves/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0404.%E5%B7%A6%E5%8F%B6%E5%AD%90%E4%B9%8B%E5%92%8C.md
     * 和题解时间复杂度和空间复杂度一致
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {3,9,20,null,null,15,7};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.sumOfLeftLeaves(root));

    }

    static class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root.left == null && root.right == null){
                return 0;
            }
            return sumLeft(root, false, 0);
        }
        public int sumLeft(TreeNode root, boolean flag, int result){
            if(root.left == null && root.right == null){
                if(flag){
                    return result + root.val;
                }else {
                    return result;
                }
            }

            if(root.left!=null){
                result = sumLeft(root.left, true, result);
            }
            if(root.right!=null){
                result = sumLeft(root.right, false, result);
            }
            return result;
        }
    }
}
