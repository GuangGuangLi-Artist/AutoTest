package codesuixiang.twoTree;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 反转2叉树
 */
public class Lee_226 {

    @Test(description = "反转二叉树")
    public void testInverTree(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode inverted = invertTree(root);

        PreOrder pr = new PreOrder();
        List<Integer> integerList = new ArrayList<>();
        pr.preOrderTree(inverted,integerList);
        System.out.println(integerList);

    }

    @Test(description = "反转二叉树 层序遍历")
    public void testInverTreeByLevel(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode inverted = invertTreeByLevel(root);

        PreOrder pr = new PreOrder();
        List<Integer> integerList = new ArrayList<>();
        pr.preOrderTree(inverted,integerList);
        System.out.println(integerList);

    }

    //DFS递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        swapChild(root);
        return root;


    }

    //BFS

    public TreeNode invertTreeByLevel(TreeNode root) {
        if (root == null) return null;
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                swapChild(temp);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
        }
        return root;
    }




    private void swapChild(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
