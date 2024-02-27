package com.course.code.binaryTree;

import java.util.Stack;

/**
 * 530.二叉搜索树的最小绝对差
 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0530.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E5%B0%8F%E7%BB%9D%E5%AF%B9%E5%B7%AE.md
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值
 *
 * 思路
 * 注意是二叉搜索树，二叉搜索树可是有序的。 那么二叉搜索树采用中序遍历，其实就是一个有序数组。
 */
public class GetMinimumDifference {

    //递归法
    TreeNode pre;//记录上一个遍历的节点
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        //左
        traversal(root.left);

        //中
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);

        }

        pre = root;

        //右
        traversal(root.right);
    }


    // 迭代法 中序遍历

    TreeNode preIte;
    Stack<TreeNode> stack;
    public int getMinimumDifferenceByIterator(TreeNode root) {
        if (root == null) {
            return 0;
        }

        stack = new Stack<>();
        TreeNode cur = root;
        int result = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if (pre != null) {
                    result = Math.min(result,cur.val = pre.val);
                }
                pre = cur;
                cur = cur.right;//右
            }
        }
        return result;
    }
}
