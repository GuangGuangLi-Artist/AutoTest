package com.course.code.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的统一迭代法
 *     那我们就将访问的节点放入栈中，把要处理的节点也放入栈中但是要做标记。
 *     如何标记呢，就是要处理的节点放入栈之后，紧接着放入一个空指针作为标记。 这种方法也可以叫做标记法。
 */
public class UnifiedIteration {

    //前序迭代遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root != null) {
            st.push(root);
        }

        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if(node != null) {
                st.pop();// 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if(node.right != null) {
                    st.push(node.right);// 添加右节点（空节点不入栈
                }
                if(node.left != null) {
                    st.push(node.left);// 添加左节点（空节点不入栈
                }
                st.push(node);
                st.push(null);// 中节点访问过，但是还没有处理，加入空节点做为标记。
            }else {//只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();// 将空节点弹出
                node = st.peek();// 重新取出栈中元素
                st.pop();
                res.add(node.val);// 加入到结果集
            }
        }
        return  res;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if(node != null) {
                stack.pop();// 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if(node.right != null) stack.push(node.right);// 添加右节点（空节点不入栈）
                stack.push(node);// 添加中节点
                stack.push(null);// 中节点访问过，但是还没有处理，加入空节点做为标记。
                if(node.left != null) stack.push(node.left);// 添加左节点（空节点不入栈）
            }else {// 只有遇到空节点的时候，才将下一个节点放进结果集
                stack.pop();// 将空节点弹出
                node = stack.peek();// 重新取出栈中元素
                stack.pop();
                res.add(node.val);
            }
        }

        return  res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if(node != null) {
                stack.pop();// 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                stack.push(node);// 添加中节点
                stack.push(null);// 中节点访问过，但是还没有处理，加入空节点做为标记。
                if(node.right != null) stack.push(node.right);// 添加右节点（空节点不入栈）
                if(node.left != null) stack.push(node.left); // 添加左节点（空节点不入栈）
            }else {// 只有遇到空节点的时候，才将下一个节点放进结果集
                stack.pop();// 将空节点弹出
                node = stack.peek(); // 重新取出栈中元素
                stack.pop();
                res.add(node.val);// 加入到结果集
            }
        }
        return res;
    }

}
