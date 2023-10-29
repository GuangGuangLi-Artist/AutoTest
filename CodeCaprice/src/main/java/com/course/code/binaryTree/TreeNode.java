package com.course.code.binaryTree;

/**
 * 这是一个二叉树的定义
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){};

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //添加节点
    public void add (int data) {
        if (this.val > data) {
            if(this.left == null) {
                this.left = new TreeNode(data);
            }else {
                this.left.add(data);
            }

        }else if (this.val < data){
            if (this.right == null) {
                this.right = new TreeNode(data);
            }else {
                this.right.add(data);
            }
        }
    }
}
