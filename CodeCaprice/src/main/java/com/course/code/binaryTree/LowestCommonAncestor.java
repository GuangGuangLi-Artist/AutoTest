package com.course.code.binaryTree;


import org.testng.annotations.Test;

/**
 * 236. 二叉树的最近公共祖先
 *
 *     给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 *     百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *     例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *     示例 1: 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出: 3 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *     示例 2: 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 输出: 5 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        //后序遍历
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        }else if (left == null && right != null) { // 若找到一个节点
            return right;
        }else if (left != null && right == null) { // 若找到一个节点
            return left;
        }else { // 若找到两个节点
            return root;
        }
    }

    @Test
    public void testLowestCommonAncestor() {
        TreeUtils utils = new TreeUtils();
        TreeNode root = utils.buildTree("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode node = lowestCommonAncestor(root, root.left.right.left, root.left.right.right);
        System.out.println(node.val);


    }
}
