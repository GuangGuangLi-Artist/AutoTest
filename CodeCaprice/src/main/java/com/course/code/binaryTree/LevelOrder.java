package com.course.code.binaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 要借用一个辅助数据结构即队列来实现，队列先进先出，符合一层一层遍历的逻辑，而用栈先进后出适合模拟深度优先遍历也就是递归的逻辑。
 * 而这种层序遍历方式就是图论中的广度优先遍历，只不过我们应用在二叉树上。
 */
public class LevelOrder {
    public List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //checkFun01(root,0);
        checkFun02(root);
        return resList;
    }

    //DFS --递归遍历
    public void checkFun01(TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (resList.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);

    } 

    //BFS--迭代方式--借助队列
    public void checkFun02(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode tmpNode = queue.poll();
                itemList.add(tmpNode.val);
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                len--;
            }
            resList.add(itemList);
        }
    }
}
