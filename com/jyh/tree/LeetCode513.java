package com.jyh.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode513 {
    /**
     * 513. 找树左下角的值
     * leetcode url : https://leetcode.cn/problems/find-bottom-left-tree-value/
     * 代码随想录 url : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0513.%E6%89%BE%E6%A0%91%E5%B7%A6%E4%B8%8B%E8%A7%92%E7%9A%84%E5%80%BC.md
     * 已解决，和题解一样。
     */
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Integer[] nodeValArray = {1,2,3,4,null,5,6,null,null,7};
        TreeNode root = TreeCreator.Create(nodeValArray);
        System.out.println(s1.findBottomLeftValue(root));

    }

    static class Solution {
        public int findBottomLeftValue(TreeNode root) {
            int ans = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    ans = node.val;
                    if (node.right != null){
                        queue.offer(node.right);
                    }
                    if (node.left != null){
                        queue.offer(node.left);
                    }
                }
            }
            return ans;
        }
    }
}
