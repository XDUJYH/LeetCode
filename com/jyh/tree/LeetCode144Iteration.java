package com.jyh.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * leetcode url : https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 * 这是迭代版本的前序遍历，要学会通过栈来处理这个遍历的思想，前序遍历顺序：中-左中-右中，入栈顺序：中-右中-左中，输出顺序就是中-左中-右中了
 */
public class LeetCode144Iteration {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        // 这是非统一迭代版本
        // 前序遍历顺序：中-左中-右中，入栈顺序：中-右中-左中
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                ans.add(node.val);
                if (node.right != null){
                stack.push(node.right);
                }
                if (node.left != null){
                stack.push(node.left);
                }
            }
            return ans;
        }
        // 这是统一迭代版本
        public List<Integer> preorderTraversal_v2(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null){
                return ans;
            }
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            TreeNode node = root;
            while (!stack.isEmpty()){
                node = stack.peek();
                if(node != null){
                    stack.pop();
                    if (node.right!=null){
                        stack.push(node.right);
                    }
                    if (node.left!=null){
                        stack.push(node.left);
                    }
                    stack.push(node);
                    stack.push(null);
                }
                else{
                    stack.pop();
                    node = stack.pop();
                    ans.add(node.val);
                }
            }
            return ans;
        }
    }
}
