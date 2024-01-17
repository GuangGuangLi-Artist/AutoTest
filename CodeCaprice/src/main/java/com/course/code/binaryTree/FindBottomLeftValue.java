package com.course.code.binaryTree;


import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  513 找树左下角的值  https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0513.%E6%89%BE%E6%A0%91%E5%B7%A6%E4%B8%8B%E8%A7%92%E7%9A%84%E5%80%BC.md
 *      给定一个二叉树，在树 的最后一行找到最左边的值。
 *
 *      首先要是最后一行，然后是最左边的值。
 *
 */
public class FindBottomLeftValue {

    // 递归法
    private int deepV = -1;
    private int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (deep > deepV) {
                value = root.val;
                deepV = deep;
            }
        }

        if (root.left != null) findLeftValue(root.left,deep + 1);
        if (root.right != null) findLeftValue(root.right,deep + 1);
    }


    //迭代法 只需要记录最后一行第一个节点的数值就可以了。
    public int findBottomLeftValueByIterator (TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int value = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pop();
                if( i == 0 ) {
                    value = cur.val;
                }

                if(cur.left != null) {
                    deque.offer(cur.left);
                }

                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }

        }
        return value;
    }


    @Test
    public void testFindValue() {
        TreeUtils t = new TreeUtils();
        TreeNode node = t.buildTree("[1,2,3,4,null,5,6,null,null,7]");
        int value = findBottomLeftValueByIterator(node);
        System.out.println(value);

    }
}
