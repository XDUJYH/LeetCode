package com.jyh.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode102 {
    /**
     * 102. 二叉树的层序遍历
     * leetcode url : https://leetcode.cn/problems/binary-tree-level-order-traversal/
     * 注意题解的写法跟我的写法的不同之处，题解的写法更清晰！我这每次循环都会判断size的情况！！题解更好！！！
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {3,9,20,null,null,15,7};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.levelOrder(root));

    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if(root == null){
                return result;
            }
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            int size;
            queue.offer(root);
            size = 1;
            List<Integer> tempt = new ArrayList<Integer>();
            while (!queue.isEmpty()||tempt.size()!=0){//只要队列不为空或者缓存数组中还有值就要
                if(size != 0){
                    TreeNode node = queue.poll();
                    tempt.add(node.val);
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if (node.right != null){
                        queue.offer(node.right);
                    }
                    size--;
                }
                else{
                    size = queue.size();
                    result.add(tempt);
                    tempt = new ArrayList<Integer>();
                }
            }
            return result;
        }
    }
}
