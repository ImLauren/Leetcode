package org.exercise.binaryTree;

public class DFS {

    /**
     * leetcdoe283 二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth)+1;
        }
    }

    /**
     * leetcdoe1448 统计二叉树中好节点的数目
     */
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node, int maxValue) {
        if (node==null) {
            return  0;
        }
        int res=0;
        if (node.val >= maxValue) {
            res++;
            maxValue = node.val;
        }
        res = res + dfs(node.left, maxValue) + dfs(node.right, maxValue);
        return res;
    }


}
