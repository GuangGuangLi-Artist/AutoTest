package com.course.code.binaryTree;


import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 112 路径总和  https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0112.%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.md
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Haspathsum {

    public boolean hasPathSumByRecursion(TreeNode root,int targetSum) {
        if( root == null) {
            return false;
        }

        targetSum -= root.val;

        if(root.left == null && root.right == null) {
            return targetSum == 0;
        }

        if (root.left != null) {
            boolean left = hasPathSumByRecursion(root.left,targetSum);
            if(left) {
                return true;
            }

        }

        if (root.right != null) {
            boolean right = hasPathSumByRecursion(root.right,targetSum);
            if(right) {
                return true;
            }
        }

        return false;
    }


    //迭代法
    public boolean hasPathSumByIterator(TreeNode root,int targetSun) {
        if (root == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);

        while (!stack1.isEmpty()) {
            int size = stack1.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();

                // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                if(node.left == null && node.right == null && sum == targetSun) {
                    return true;
                }

                if(node.right != null) {
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }

                if(node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }
    return false;
    }


    public List<List<Integer>> pathSum(TreeNode root,int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new LinkedList<>();
        preOrderDfs(root,targetSum,res,path);
        return res;
    }

    private void preOrderDfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);

        //遇到了叶子节点
        if(root.left == null && root.right == null) {
            //找到了和为targetSum的路径
            if(targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return;//和不为targetSum 返回
        }

        if(root.left != null) {
            preOrderDfs(root.left,targetSum - root.val,res,path);
            path.remove(path.size() - 1); // 回溯
        }

        if(root.right != null) {
            preOrderDfs(root.right,targetSum - root.val,res,path);
            path.remove(path.size() - 1); // 回溯
        }

    }

    public  List<List<Integer>> pathSumByIter(TreeNode root,int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        Stack<ArrayList<Integer>> pathStack = new Stack<>();
        if(root== null) return res;
        nodeStack.push(root);
        sumStack.push(root.val);
        pathStack.push(new ArrayList<>());
        while (!nodeStack.isEmpty()) {
            TreeNode curNode = nodeStack.peek();
            int curSum = sumStack.pop();
            ArrayList<Integer> curPath = pathStack.pop();
            if(curNode != null) {
                nodeStack.pop();
                nodeStack.add(curNode);
                nodeStack.add(null);
                sumStack.add(curSum);
                curPath.add(curNode.val);
                pathStack.add(new ArrayList<>(curPath));

                if(curNode.right != null) {
                    nodeStack.add(curNode.right);
                    sumStack.add(curSum + curNode.right.val);
                    pathStack.add(new ArrayList<>(curPath));
                }

                if(curNode.left != null) {
                    nodeStack.add(curNode.left);
                    sumStack.add(curSum + curNode.left.val);
                    pathStack.add(new ArrayList<>(curPath));
                }
            }else {
                nodeStack.pop();
                TreeNode temp = nodeStack.pop();
                if (temp.left == null && temp.right == null && curSum == targetSum) {
                    res.add(new ArrayList<>(curPath));
                }
            }
        }
        return res;

    }


    @Test
    public void testHasPathSum() {
        TreeUtils treeUtils = new TreeUtils();
        TreeNode treeNode = treeUtils.buildTree("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        boolean b = hasPathSumByRecursion(treeNode, 22);
        List<List<Integer>> lists = pathSum(treeNode, 22);
        System.out.println(b);
        System.out.println("------");
        System.out.println(StringUtils.join("",lists));
        System.out.println("------");
        List<List<Integer>> listByIte = pathSumByIter(treeNode, 22);
        System.out.println(StringUtils.join("",listByIte));
    }



}
