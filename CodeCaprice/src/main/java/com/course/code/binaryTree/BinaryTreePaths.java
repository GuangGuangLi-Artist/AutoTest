package com.course.code.binaryTree;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

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


    //递归法

    public List<String> binaryTreePathsByRecursion(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();//作为结果中的路径
        traversal(root,paths,res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);//前序遍历 中
        if(root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));//记录最后一个节点
            res.add(sb.toString());//收集一个路径
            return;
        }

        //递归和回溯是同时进行，所以放在一个花括号里
        if(root.left != null) {
            traversal(root.left,paths,res);
            paths.remove(paths.size() - 1);//回溯
        }
        if(root.right != null) {
            traversal(root.right,paths,res);
            paths.remove(paths.size() - 1);//回溯
        }
    }


    @Test
    public void testBinaryTreePaths() {
        TreeUtils treeUtils = new TreeUtils();
        TreeNode tree = treeUtils.buildTree("[1,2,3,null,5]");
        List<String> strings = binaryTreePaths(tree);
        System.out.println(StringUtils.join(" ", strings));
    }
}
