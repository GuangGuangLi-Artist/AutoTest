package com.course.code.binaryTree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 222.完全二叉树的节点个数
 *  给出一个完全二叉树，求出该树的节点个数。
 *  示例 1：
 *      输入：root = [1,2,3,4,5,6]
 *      输出：6
 */
public class CountNodes {

    //递归法
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    //迭代法
    public int countNodes2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = 0;
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                res++;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }

        }
        return res;
    }

    public int countNodes3(TreeNode root) {
        /**
         * 针对完全二叉树的解法
         * 满二叉树的结点数为：2^depth - 1
         */
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0,rightDepth = 0;
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right!= null) {
            right = right.right;
            rightDepth++;
        }

        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }
        return countNodes3(root.left) + countNodes3(root.right) + 1;
    }
}
