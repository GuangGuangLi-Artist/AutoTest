package codesuixiang.twoTree;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代法遍历二叉树
 */
public class PreOrderByStack {

    @Test
    public  void testpreByStack() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        List<Integer> preorder = preorder(root);
        System.out.println(preorder);
    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        //前序遍历顺序：中-左-右，入栈顺序：中-右-左
        if (root == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.value);
            if(node.right != null){
                stack.push(node.right);

            }

            if (node.left != null){
                stack.push(node.left);
            }
        }
        return list;

    }
}
