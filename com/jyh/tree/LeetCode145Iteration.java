package com.jyh.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * leetcode url : https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * 这是迭代版本的后序遍历，通过前序迭代版本可推出来！！非常巧妙，通过观察遍历顺序来改变入栈顺序出栈顺序！
 */
public class LeetCode145Iteration {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        // 这是非统一迭代版本
        // 后序遍历顺序 左中-右中-中 入栈顺序：中-左中-右中 出栈顺序：中-右中-左中， 最后翻转结果得到左中-右中-中的情况！
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                ans.add(node.val);
                if (node.left != null){
                    stack.push(node.left);
                }
                if (node.right != null){
                    stack.push(node.right);
                }
            }
            Collections.reverse(ans);
            return ans;
        }
        //这是统一迭代版本
        public List<Integer> postorderTraversal_v2(TreeNode root) {
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
                    stack.push(node);
                    stack.push(null);
                    if (node.right!=null){
                        stack.push(node.right);
                    }
                    if (node.left!=null){
                        stack.push(node.left);
                    }
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
