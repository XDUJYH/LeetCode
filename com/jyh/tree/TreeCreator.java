package com.jyh.tree;

import java.util.LinkedList;

public class TreeCreator {
    public static TreeNode Create(Integer[] nodeValArray){
        LinkedList<TreeNode> queueNode = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode();
        queueNode.offer(root);
        int index = 1;
        while (!queueNode.isEmpty()){
            TreeNode node = queueNode.poll();
            Integer val = nodeValArray[index - 1];
            if(val != null){
                node.val = val;
            }
            if(index*2 < nodeValArray.length + 1){
                if(nodeValArray[index*2 - 1] != null){
                    node.left = new TreeNode();
                    queueNode.offer(node.left);
                }
                else{
                    node.left = null;
                    queueNode.offer(node.left);
                }

            }
            if (index * 2 + 1 < nodeValArray.length + 1) {
                if(nodeValArray[index*2] != null){
                    node.right = new TreeNode();
                    queueNode.offer(node.right);
                }
                else{
                    node.right = null;
                    queueNode.offer(node.right);
                }
            }
            index++;
        }
        return root;
    }
}
