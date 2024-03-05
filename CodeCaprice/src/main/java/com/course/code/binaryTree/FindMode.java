package com.course.code.binaryTree;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 501.二叉搜索树中的众数
 *     给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *     假定 BST 有如下定义：
 *         结点左子树中所含结点的值小于等于当前结点的值
 *         结点右子树中所含结点的值大于等于当前结点的值
 *         左子树和右子树都是二叉搜索树
 *
 *
 *   思路法
 *      递归法
 *      1 这个树都遍历了，用map统计频率
 *      2 把统计的出来的出现频率（即map中的value）排个序
 *      3 取前面高频的元素
 *      既然是搜索树，它中序遍历就是有序的。
 *
 */
public class FindMode {
    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findMode1(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;
    }

    public void findMode1(TreeNode root) {
        if (root == null) {
            return;
        }
        findMode1(root.left);

        int rootValue = root.val;

        if (pre == null || rootValue != pre.val) {
            count = 1;
        }else {
            count++;
        }

        // 更新结果以及maxCount
        if (count > maxCount) {
            resList.clear();
            resList.add(rootValue);
            maxCount = count;
        }else if (count == maxCount) {
            resList.add(rootValue);
        }
        pre = root;
        findMode1(root.right);
    }


    //迭代法
    public int[] findModeByIterator(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        int maxCount = 0;
        int count = 0;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                //计数
                if (pre == null || cur.val != pre.val) {
                    count = 1;
                }else {
                    count++;
                }

                //更新结果
                if (count > maxCount) {
                    maxCount = count;
                    result.clear();
                    result.add(cur.val);
                }else if (count == maxCount) {
                    result.add(cur.val);
                }

                pre = cur;
                cur = cur.right;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void testFindMode() {
        TreeUtils utils = new TreeUtils();
        TreeNode root = utils.buildTree("[1,null,2,2]");
        FindMode fm = new FindMode();
        int[] mode = fm.findMode(root);
        System.out.println(Arrays.toString(mode));
    }
}
