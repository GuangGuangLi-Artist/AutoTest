package com.course.code.binaryTree;


import java.util.Stack;

/**
 * 112 路径总和  https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0112.%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.md
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Haspathsum {

    public boolean hasPathSumByRecursion(TreeNode root,int targetSum) {
        if( root == null) {
            return false;
        }

        targetSum -= root.val;

        if(root.left == null && root.right == null) {
            return targetSum == 0;
        }

        if (root.left != null) {
            boolean left = hasPathSumByRecursion(root.left,targetSum);
            if(left) {
                return true;
            }

        }

        if (root.right != null) {
            boolean right = hasPathSumByRecursion(root.right,targetSum);
            if(right) {
                return true;
            }
        }

        return false;
    }


    //迭代法
    public boolean hasPathSumByIterator(TreeNode root,int targetSun) {
        if (root == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);

        while (!stack1.isEmpty()) {
            int size = stack1.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();

                // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                if(node.left == null && node.right == null && sum == targetSun) {
                    return true;
                }

                if(node.right != null) {
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }

                if(node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }
    return false;
    }



}
