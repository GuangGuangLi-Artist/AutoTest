package com.course.code.binaryTree;


/**
 * 654 最大二叉树  https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0654.%E6%9C%80%E5%A4%A7%E4%BA%8C%E5%8F%89%E6%A0%91.md
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 *     二叉树的根是数组中的最大元素。
 *     左子树是通过数组中最大值左边部分构造出的最大二叉树。
 *     右子树是通过数组中最大值右边部分构造出的最大二叉树。
 *
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums,0,nums.length);
    }

    private TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) { //没有元素了
            return null;
        }

        if(rightIndex - leftIndex == 1) {//只有一个元素
            return new TreeNode(nums[leftIndex]);
        }

        int maxIndex = leftIndex;// 最大值所在位置
        int maxVal = nums[maxIndex];// 最大值
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if(nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        //根据maxIndex划分左右子树
        root.left = constructMaximumBinaryTree1(nums,leftIndex,maxIndex);
        root.right = constructMaximumBinaryTree1(nums,maxIndex + 1,rightIndex);
        return root;
    }
}
