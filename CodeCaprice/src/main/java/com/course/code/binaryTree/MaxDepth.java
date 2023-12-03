package com.course.code.binaryTree;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  104 二叉树的最大深度
 *      给定一个二叉树，找出其最大深度。
 *      二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 *      说明: 叶子节点是指没有子节点的节点。
 *      示例： 给定二叉树 [3,9,20,null,null,15,7]，返回它的最大深度 3 。
 *
 *      第一种方法 递归法
 *      本题可以使用前序（中左右），也可以使用后序遍历（左右中），使用前序求的就是深度，使用后序求的是高度。
 *      二叉树节点的深度：指从根节点到该节点的最长简单路径边的条数或者节点数（取决于深度从0开始还是从1开始）
 *      二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数或者节点数（取决于高度从0开始还是从1开始）
 *
 *      第二种方法 递归法
 *      使用迭代法的话，使用层序遍历是最为合适的，因为最大的深度就是二叉树的层数，和层序遍历的方式极其吻合。
 *
 */
public class MaxDepth {


    @Test
    public void testMaxDepth1() {
        /**
         * 递归
         */
        TreeUtils treeUtils = new TreeUtils();
        TreeNode tree = treeUtils.buildTree("[3,9,20,null,null,15,7]");
        System.out.println(maxDepth1(tree));
        System.out.println("----------");
//        System.out.println(maxDepth2(tree));


    }

    public int maxDepth1(TreeNode root) {
        if(root == null) {
            int i = 0;
            return i;
        }
        int leftDepth = maxDepth1(root.left);
        int rightDepth = maxDepth1(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }


    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if(node.left != null) {
                    deque.offer(node.left);
                }
                if(node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return depth;
    }



}
