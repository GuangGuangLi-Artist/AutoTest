package com.course.code.binaryTree;


import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class TestLevelOrder {
    public static void main(String[] args) {
        TreeUtils t = new TreeUtils();
        TreeNode node = t.buildTree("[5,4,6,1,2,7,8]");
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> lists = levelOrder.levelOrder(node);
        System.out.println(StringUtils.join("",lists));

    }


}
