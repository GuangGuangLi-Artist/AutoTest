package com.course.code.binaryTree;


/**
 * 669. 修剪二叉搜索树
 *   给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low,int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right,low,high);
        }
        if (root.val > high) {
            return trimBST(root.left,low,high);
        }

        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }


    public TreeNode trimBSTByIteration(TreeNode root, int low,int high) {
        if (root == null) return null;
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val <low)
                root = root.right;
            else
                root = root.left;
        }

        TreeNode cur = root;
        while (cur != null) {
            while (cur.left != null && cur.left.val < low) {
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }
        cur = root;

        while (cur != null) {
            while (cur.right != null && cur.right.val > high) {
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }

        return root;
    }


}
