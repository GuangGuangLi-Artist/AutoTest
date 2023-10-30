package com.course.code.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树调试工具类
 * 根据层次遍历的二叉树字符串形式构造二叉树
 */
class TreeUtils {
    // 分隔符
    String SEP = ",";
    // 空值
    String NULL = "null";

    /* 将字符串反序列化为二叉树结构 */
    TreeNode buildTree(String data) {
        if (data.isEmpty()) return null;
        // 去除首位"[", "]"
        data = data.substring(1,data.length()-1);
        // 在data后加若干个空值
        for(int i = 0; i < 100; i++) data += SEP + NULL;
        String[] nodes = data.split(SEP);
        // 第一个元素就是 root 的值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        // 队列 q 记录父节点，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < nodes.length; ) {
            // 队列中存的都是父节点
            TreeNode parent = q.poll();
            if(parent == null) break;
            // 父节点对应的左侧子节点的值
            String left = nodes[i++];
            if (!left.equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            } else {
                parent.left = null;
            }
            // 父节点对应的右侧子节点的值
            String right = nodes[i++];
            if (!right.equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;
    }
}
