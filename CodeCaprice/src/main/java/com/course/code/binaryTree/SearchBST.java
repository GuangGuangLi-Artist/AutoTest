package com.course.code.binaryTree;


import java.util.Stack;

/**
 * 700 二叉树搜索树中的搜索  https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0700.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E6%90%9C%E7%B4%A2.md
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 *
 * 二叉搜索树是一个有序树：
 *
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉搜索树
 *
 */
public class SearchBST {
    //递归
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        TreeNode left = searchBST(root.left,val);
        if (left != null) {
            return left;
        }

        return searchBST(root.right,val);
    }

    //二叉搜索树的特点优化
    public TreeNode searchBSTUp(TreeNode root,int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBSTUp(root.left,val);
        }else {
            return searchBSTUp(root.right,val);
        }
    }

    //迭代法
    public TreeNode searchBSTByIte(TreeNode root,int val) {
        if (root == null || root.val == val) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == val) {
                return node;
            }

            if(node.right != null) {
                stack.push(node.right);

            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return null;
    }
}
