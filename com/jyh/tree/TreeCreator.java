package com.jyh.tree;

import java.util.LinkedList;

public class TreeCreator {
    public static TreeNode Create(Integer[] nodeValArray){
        if(nodeValArray.length == 0){
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<TreeNode> queueNode = new LinkedList<>();
        for (int i = 1; i < nodeValArray.length; i++) {
            queue.offer(nodeValArray[i]);
        }
        TreeNode root = new TreeNode(nodeValArray[0]);
        queueNode.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queueNode.poll();
            //为左节点赋值
            if(queue.size() != 0){
                Integer val = queue.poll();
                if(val != null){
                    TreeNode newNode = new TreeNode(val);
                    node.left = newNode;
                    queueNode.offer(node.left);
                }else {
                    node.left = null;
                }
            }

            //为右节点赋值
            if(queue.size() != 0){
                Integer val = queue.poll();
                if(val != null){
                    TreeNode newNode = new TreeNode(val);
                    node.right = newNode;
                    queueNode.offer(node.right);
                }else {
                    node.right = null;
                }
            }else {
                node.right = null;
            }
        }

        return root;
    }
    public static TreeNode CreateV1(Integer[] nodeValArray){
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
