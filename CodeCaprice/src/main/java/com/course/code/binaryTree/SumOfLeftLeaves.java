package com.course.code.binaryTree;


import org.testng.annotations.Test;

import java.util.Stack;

/**
 *  404 左叶子之和  https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0404.%E5%B7%A6%E5%8F%B6%E5%AD%90%E4%B9%8B%E5%92%8C.md
 *      计算给定二叉树的所有左叶子之和。
 *
 *      左叶子的明确定义：节点A的左孩子不为空，且左孩子的左右孩子都为空（说明是叶子节点），那么A节点的左孩子为左叶子节点
 *
 */
public class SumOfLeftLeaves {

    //递归法 后序遍历（左右中）

    public int sumOfLeftLeavesByRecursio(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = sumOfLeftLeavesByRecursio(root.left);
        int rightValue = sumOfLeftLeavesByRecursio(root.right);

        int midValue = 0;
        if(root.left != null && root.left.left == null && root.right.right == null) {
            //判断是左叶子
            midValue = root.left.val;
        }

        int sum = midValue + leftValue + rightValue; //中
        return sum;

    }

    public int sumOfLeftLeavesByIterator(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int res = 0;
        while (!stack.isEmpty()) {
            TreeNode  node = stack.pop();
            if(node.left != null && node.left.left == null && node.right.right == null) {
                res += node.left.val;
            }

            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }
        }
        return res;
    }


    @Test
    public void testSumOfLeftLeaves() {
        TreeUtils treeUtils = new TreeUtils();
        TreeNode tree = treeUtils.buildTree("[3,9,20,null,null,15,7]");
        System.out.println(sumOfLeftLeavesByIterator(tree));

    }
}
