package codesuixiang.twoTree;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历二叉树
 *
 * 递归遍历二叉树
 *
 * 递归需要确认的条件
 * 第一步 确认递归任务的入参和返回结果类型
 * 第二步 确认递归的准出条件 避免死循环
 * 第三步 确定单层递归的逻辑
 *
 */
public class PreOrder {

    @Test(description = "前序遍历二叉树 中左右")
    public void  testPreOrder() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        List<Integer> result = new ArrayList<>();
        preOrderTree(root, result);
        System.out.println(result);

    }

    @Test(description = "中序遍历二叉树 左中右")
    public void testInOrder() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        List<Integer> result = new ArrayList<>();
        inOrderTree(root, result);
        System.out.println(result);
    }

    @Test(description = "后序遍历二叉树 左右中")
    public void testPostOrder() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        List<Integer> result = new ArrayList<>();
        postOrderTree(root, result);
        System.out.println(result);
    }

    //确认递归的入参和返回结果  遍历二叉树 将节点值存入List结果
    public void preOrderTree(TreeNode root, List<Integer> result) {

        //确认准出条件
          if (root == null) {
              return;
          }
          result.add(root.value);
          preOrderTree(root.left, result);
          preOrderTree(root.right, result);

    }

    //中序遍历  左中右
    public void inOrderTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        //左中右
        inOrderTree(root.left, result);
        result.add(root.value);
        inOrderTree(root.right, result);
    }

    //后续遍历
    public void postOrderTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        //后续遍历 左右中
        postOrderTree(root.left, result);
        postOrderTree(root.right, result);
        result.add(root.value);

    }
}
