package codesuixiang.twoTree;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层序遍历
 */
public class LevelOrder {

    @Test
    public void testLevelOrder() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(8);

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }

    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
         result = new ArrayList<List<Integer>>();
        checkFunc02(root);
        return result;

    }

    //BFS--迭代方式--借助队列
    public void checkFunc02(TreeNode root) {
        if (root == null ) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int size = queue.size();//查看队列的大小
            while (size > 0){
                // queue.peek(); 查看对头元素

                TreeNode tmpNode = queue.poll(); //移除并返回队头元素
                itemList.add(tmpNode.value);
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);//队列添加元素
                }
                size--;
            }
            result.add(itemList);
        }
    }
}
