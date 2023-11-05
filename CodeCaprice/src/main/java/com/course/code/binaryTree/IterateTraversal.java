package com.course.code.binaryTree;

import org.testng.annotations.Test;

import java.util.*;

/**
 * 迭代法遍历二叉树
 *     递归的实现就是：每一次递归调用都会把函数的局部变量、参数值和返回地址等压入调用栈中，然后递归返回的时候，从栈顶弹出上一次递归的各项参数，
 *     所以这就是递归为什么可以返回上一层位置的原因。
 */
public class IterateTraversal {
    // 前序遍历顺序：中-左-右，入栈顺序：中-右-左
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    @Test
    public void testPreorderTraversal() {
        TreeUtils t = new TreeUtils();
        TreeNode node = t.buildTree("[5,4,6,1,2,7,8]");
        List<Integer> list = preorderTraversal(node);
        System.out.println(Arrays.asList(list));
    }

    // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    @Test
    public void testInorderTraversal() {
        TreeUtils t = new TreeUtils();
        TreeNode node = t.buildTree("[5,4,6,1,2,7,8]");
        List<Integer> list = inorderTraversal(node);
        System.out.println(Arrays.asList(list));
    }

    // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }


    @Test
    public void testPostorderTraversal() {
        TreeUtils t = new TreeUtils();
        TreeNode node = t.buildTree("[5,4,6,1,2,7,8]");
        List<Integer> list = postorderTraversal(node);
        System.out.println(Arrays.asList(list));
    }
}
