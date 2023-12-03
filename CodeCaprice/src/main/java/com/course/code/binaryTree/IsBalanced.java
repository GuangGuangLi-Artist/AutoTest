package com.course.code.binaryTree;

/**
 * 110.平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 返回 true 。
 */
public class IsBalanced {

    /**
     * 迭代法
     */

    public boolean isBalance(TreeNode root) {
        return getHeight1(root) != -1;


    }

    private int getHeight1(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = getHeight1(root.left);
        if(leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight1(root.right);
        if(rightHeight == -1) {
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight,rightHeight) + 1;
    }


}
