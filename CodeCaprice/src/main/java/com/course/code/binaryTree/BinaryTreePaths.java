package com.course.code.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class BinaryTreePaths {

    //迭代法
    public List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Stack<Object> stack = new Stack<>();

        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();

            if(node.left == null && node.right == null) {
                result.add(path);
            }

            if(node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            if(node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        return result;
    }
}
