package com.course.code.binaryTree;


import java.util.Stack;

/**
 * 538.把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 *     节点的左子树仅包含键 小于 节点键的节点。 节点的右子树仅包含键 大于 节点键的节点。 左右子树也必须是二叉搜索树。
 *    输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 *    输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 */
public class ConvertBST {

    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBST1(root);
        return root;
    }

    private void convertBST1(TreeNode root) {
        if (root == null) {
            return;
        }

        convertBST1(root.right);
        sum += root.val;
        root.val = sum;
        convertBST1(root.left);
    }



    public TreeNode convertBSTByIterator(TreeNode root) {
        int pre = 0;
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return null;

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (curr != null) {
                stack.pop();
                if (curr.left != null)
                    stack.add(curr.left);
                stack.add(curr);
                stack.add(null);
                if (curr.right != null)
                    stack.add(curr.right);
            }else {
                stack.pop();
                TreeNode temp = stack.pop();
                temp.val += pre;
                pre = temp.val;
            }
        }
        return root;
    }
}
