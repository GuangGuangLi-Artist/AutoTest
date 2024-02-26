package com.course.code.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 106 从中序与后序遍历序列构造二叉树  https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0106.%E4%BB%8E%E4%B8%AD%E5%BA%8F%E4%B8%8E%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91.md
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 例如，给出
 *     中序遍历 inorder = [9,3,15,20,7]
 *     后序遍历 postorder = [9,15,7,20,3]
 *     就是以 后序数组的最后一个元素为切割点，先切中序数组，根据中序数组，反过来再切后序数组。一层一层切下去，每次后序数组最后一个元素就是节点元素。
 *
 *
 */
public class GenerateTree {

    Map<Integer,Integer> map;

    public TreeNode buildTree(int[] inorder,int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return findNode(inorder,0,inorder.length,postorder,0,postorder.length);//// 前闭后开
    }

    private TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {

        if(inBegin >= inEnd || postBegin >= postEnd) {
            return null;
        }

        int rootIndex = map.get(postorder[postEnd - 1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex - inBegin;
        root.left = findNode(inorder,inBegin,rootIndex,postorder,postBegin,postBegin + lenOfLeft);
        root.right = findNode(inorder,rootIndex + 1,inEnd,postorder,postBegin + lenOfLeft,postEnd - 1);
        return root;
    }

    //从前序与中序遍历构造二叉树
    Map<Integer,Integer> pre_in_map;
    public TreeNode pre_in_buildTree(int[] preorder,int[] inorder) {
        pre_in_map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i );
        }

        return pre_in_findNode(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    private TreeNode pre_in_findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        // 参数里的范围都是前闭后开
        if (preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }

        int rootIndex = pre_in_map.get(preorder[preBegin]);//// 找到前序遍历的第一个元素在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenofLeft = rootIndex - inBegin; // 保存中序左子树个数，用来确定前序数列的个数
        root.left = pre_in_findNode(preorder,preBegin + 1,preBegin + lenofLeft + 1,inorder,inBegin,rootIndex);
        root.right = findNode(preorder,preBegin + lenofLeft + 1,preEnd,inorder,rootIndex + 1,inEnd);
        return  root;

    }


}
