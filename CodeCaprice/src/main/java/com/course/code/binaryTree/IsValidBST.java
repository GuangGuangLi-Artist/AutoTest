package com.course.code.binaryTree;


import java.util.Stack;

/**
 * 98 验证二叉搜索树
 *     给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *     节点的左子树只包含小于当前节点的数。
 *     节点的右子树只包含大于当前节点的数。
 *     所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {
    // 递归
    TreeNode max;
    public boolean isVaildBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //左
        boolean left = isVaildBST(root.left);
        if (!left) {
            return false;
        }

        if(max != null && root.val <= max.val) {
            return false;
        }

        max = root;

        boolean right = isVaildBST(root.right);
        return right;
    }

    //迭代
    public  boolean isValidBSTByIterator(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pre != null && pop.val <= pre.val) {
                return false;
            }
            pre = pop;
            root = pop.right;
        }
        return true;
    }
}
