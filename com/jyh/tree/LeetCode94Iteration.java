package com.jyh.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * leetcode url : https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 这是迭代版本的中序遍历，要理解！
 */
public class LeetCode94Iteration {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1);

    }

    static class Solution {
        // 这是非统一迭代版本
        // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()){//为什么还要判断cur是否为空呢，这是因为对于右节点而言，可能出现stack pop完后为空，但是右节点不为空的情况
                if(cur != null){
                    stack.push(cur);
                    cur = cur.left;   //非常的巧妙，先走左节点，然后在下个循环判断这个节点是否为空，为空则pop得到栈顶节点（也就是上一个节点），这样这个节点就满足了左节点为空，因此可以将其放入ans了，然后在将cur指向右节点，如果右节点不为空，则会在下个循环中被push到栈中。设计的非常巧妙！！！
                }else{
                    cur = stack.pop();
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
            return ans;
        }
        //这是统一迭代版本
        public List<Integer> inorderTraversal_v2(TreeNode root){
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
                    stack.push(node);
                    stack.push(null);
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
