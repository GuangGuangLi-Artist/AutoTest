package com.course.code.binaryTree;


import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最小深度
 * 111.二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 给定二叉树 [3,9,20,null,null,15,7],返回它的最小深度 2.
 * <p>
 * 本题依然是前序遍历和后序遍历都可以，前序求的是深度，后序求的是高度。
 * 二叉树节点的深度：指从根节点到该节点的最长简单路径边的条数或者节点数（取决于深度从0开始还是从1开始）
 * 二叉树节点的高度：指从该节点到叶子节点的最长简单路径边的条数后者节点数（取决于高度从0开始还是从1开始）
 */
public class MinDepth {
    /**
     * 递归法
     */

    @Test
    public void testMinDepth() {

        TreeUtils treeUtils = new TreeUtils();
        TreeNode tree = treeUtils.buildTree("[3,9,20,null,null,15,7]");
        System.out.println(minDepth2(tree));

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

    //迭代法

    public int minDepth2(TreeNode root) {
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
                TreeNode poll = deque.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return depth;
    }
}
