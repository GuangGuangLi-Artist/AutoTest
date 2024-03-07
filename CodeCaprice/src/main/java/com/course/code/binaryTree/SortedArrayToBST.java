package com.course.code.binaryTree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 108.将有序数组转换为二叉搜索树
 *     将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *     本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length);
    }

    public TreeNode sortedArrayToBST(int[] nums,int left,int right) {
        if (left >= right) {
            return null;
        }

        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,left,mid);
        root.right = sortedArrayToBST(nums,mid + 1,right);
        return root;
    }

    //迭代
     public TreeNode sortedArrayToBSTByIterator(int[] nums) {
        if (nums.length == 0) return null;

        TreeNode root = new TreeNode(-1);
         Queue<TreeNode> nodeQueue = new LinkedList<>();
         Queue<Integer> leftQueue = new LinkedList<>();
         Queue<Integer> rightQueue = new LinkedList<>();

         //根节点入队列
         nodeQueue.offer(root);
         // 0为左区间下标初始位置
         leftQueue.offer(0);
         // nums.size() - 1为右区间下标初始位置
         rightQueue.offer(nums.length - 1);

         while (!nodeQueue.isEmpty()) {
             TreeNode curNode = nodeQueue.poll();
             int left = leftQueue.poll();
             int right = rightQueue.poll();
             int mid = left + ((right - left) >> 1);

             // 将mid对应的元素给中间节点
             curNode.val = nums[mid];

             if (left <= mid -1) {
                 curNode.left = new TreeNode(-1);
                 nodeQueue.offer(curNode.left);
                 leftQueue.offer(left);
                 rightQueue.offer(mid - 1);
             }

             if (right >= mid + 1) {
                 curNode.right = new TreeNode(-1);
                 nodeQueue.offer(curNode.right);
                 leftQueue.offer(mid + 1);
                 rightQueue.offer(right);
             }
         }

         return root;
     }


}
