package com.jyh.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode257 {
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
        String concatSymbol = "->";
        public List<String> binaryTreePaths(TreeNode root) {
            LinkedList<Integer> prePath = new LinkedList<>();
            List<String> result = new LinkedList<>();
            return treePaths(root,prePath,result);
        }
        public List<String> treePaths(TreeNode root, LinkedList<Integer> prePath, List<String> result){
            if(root.left == null && root.right == null){
                prePath.push(root.val);
                //存入result
                String resultString = "";
                for (int i = prePath.size() - 1 ; i >= 0; i--) {
                    if(i == 0){
                        resultString = resultString + prePath.get(i).toString();
                    }
                    else{
                        resultString = resultString + prePath.get(i).toString() + concatSymbol;
                    }

                }
                result.add(resultString);
                //弹出栈顶元素
                prePath.pop();
                return result;
            }
            prePath.push(root.val);
            if(root.left != null){
                treePaths(root.left, prePath, result);
            }

            if(root.right != null){
                treePaths(root.right, prePath, result);
            }
            prePath.pop();
            return result;
        }
    }
}