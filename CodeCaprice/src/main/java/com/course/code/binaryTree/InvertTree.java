package com.course.code.binaryTree;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 226 反转二叉树
 */
public class InvertTree {
    //后序遍历

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);
        return root;

    }

    //BFS 层序遍历
    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) return null;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swapChildren(node);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }

        }
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //

    public List<Integer> bianLiTree(TreeNode root,List<Integer> res){
        if(root == null) {
            return res;
        }
        res.add(root.val);//中
        bianLiTree(root.left,res);
        bianLiTree(root.right,res);
        return res;
    }

    @Test
    public void testInvertTree(){
        TreeUtils utils = new TreeUtils();
        TreeNode treeNode = utils.buildTree("[4,2,7,1,3,6,9]");
        TreeNode node = invertTree(treeNode);
        List<Integer> res = new ArrayList<>();
        List<Integer> liTree = bianLiTree(node, res);
        System.out.println(Arrays.asList(liTree));

    }

    @Test
    public void testInvertTreeBFS() {
        TreeUtils utils = new TreeUtils();
        TreeNode treeNode = utils.buildTree("[4,2,7,1,3,6,9]");
        TreeNode node = invertTreeBFS(treeNode);
        List<Integer> res = new ArrayList<>();
        List<Integer> liTree = bianLiTree(node, res);
        System.out.println(Arrays.asList(liTree));
    }
}
