package org.exercise.binaryTree;

import java.util.*;

public class BFS {

    /**
     * leetcdoe199 二叉树的右视图
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
                if (i==size-1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    /**
     * leetcdoe1161 最大层内元素和
     */
    public int maxLevelSum(TreeNode root) {
        int maxValue = Integer.MIN_VALUE;
        int re = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sequence = 0;
        while(!queue.isEmpty()) {
            sequence++;
            int size = queue.size();
            int value = 0;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                value = value + node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
            }
            if (value>maxValue) {
                re = sequence;
                maxValue = value;
            }
        }
        return  re;
    }



}
