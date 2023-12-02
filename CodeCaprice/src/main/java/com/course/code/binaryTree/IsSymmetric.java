package com.course.code.binaryTree;


import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 101 对称二叉树
 *
 *  给定一个二叉树，检查它是否是镜像对称的。
 *  正是因为要遍历两棵树而且要比较内侧和外侧节点，所以准确的来说是一个树的遍历顺序是左右中，一个树的遍历顺序是右左中
 */
public class IsSymmetric {

    // 递归法
    public boolean isSymmetric(TreeNode root) {
        return cpmpare(root.left,root.right);
    }

    private boolean cpmpare(TreeNode left, TreeNode right) {
        if(left == null && right != null) {
            return false;
        }

        if(left != null && right == null) {
            return false;
        }

        if(left == null && right == null) {
            return true;
        }

        if(left.val != right.val) {
            return false;
        }

        //比较外侧
        boolean compareOutSide = cpmpare(left.left,right.right);

        //比较内侧
        boolean compareinSide = cpmpare(left.right,right.left);
        return compareOutSide && compareinSide;
    }

    //迭代法
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);//在此deque的前面插入指定的元素，除非它会违反容量限制。
        deque.offerLast(root.right);//在此deque的末尾插入指定的元素，除非它会违反容量限制。
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();//检索并删除此deque的第一个元素，如果此deque为空，则返回 null
            TreeNode rightNode = deque.pollLast();//检索并删除此deque的最后一个元素，如果此deque为空，则返回 null 。
            if(leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null && rightNode != null) return false;
            if (leftNode != null && rightNode == null) return false;
            if (leftNode.val != rightNode.val) return false;
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }

    //迭代法 使用普通队列
    public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            if(leftNode == null && rightNode == null) {
                continue;
            }

            if(leftNode == null && rightNode != null) return false;
            if(leftNode != null && leftNode == null) return false;
            if(leftNode.val != rightNode.val ) return false;

            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);


        }
        return true;


    }

    @Test
    public void testIsSymmetric() {
        TreeUtils utils = new TreeUtils();
        //TreeNode treeNode = utils.buildTree("[4,2,7,1,3,6,9]");
        TreeNode treeNode = utils.buildTree("[1,2,3,4,5,6,2,4,3,6,5]");
        boolean b = isSymmetric(treeNode);
        System.out.println(b);
    }

}
