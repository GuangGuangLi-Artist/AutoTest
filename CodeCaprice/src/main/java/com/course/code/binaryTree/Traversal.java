package com.course.code.binaryTree;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树的递归遍历
 *   如何写一个递归算法
 *       1. 确定递归函数的参数和返回值： 确定哪些参数是递归的过程中需要处理的，那么就在递归函数里加上这个参数， 并且还要明确每次递归的返回值是什么
 *       进而确定递归函数的返回类型。
 *       2. 确定终止条件: 写完了递归算法, 运行的时候，经常会遇到栈溢出的错误，就是没写终止条件或者终止条件写的不对，操作系统也是用一个栈的结构来保
 *       存每一层递归的信息，如果递归没有终止，操作系统的内存栈必然就会溢出。
 *       3. 确定单层递归的逻辑: 确定每一层递归需要处理的信息。在这里也就会重复调用自己来实现递归的过程。
 */

public class Traversal {

    //前序遍历·递归·LC144_二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {//结束条件
            return;
        }
        //单层逻辑
        result.add(root.val);//中
        preorder(root.left, result);//左
        preorder(root.right, result);//右
    }

    // 中序遍历·递归·LC94_二叉树的中序遍历

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorder(root.left, res);//左
        res.add(root.val);//中
        inorder(root.right, res);//右
    }

    // 后序遍历·递归·LC145_二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        //左 右 中
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    @Test
    public void testBianLi() {
        TreeUtils t = new TreeUtils();
        TreeNode node = t.buildTree("[5,4,6,1,2,7,8]");
        List<Integer> postorder = preorderTraversal(node);
        System.out.println(Arrays.asList(postorder));
    }

    @Test
    public void testDiGui() {
        int res = fib(5);
        System.out.println(res);
    }

    public int fib(int n) {
        if (n == 1) {
            return 1;
        }else {
             return  n * fib(n - 1);
        }


    }


}
