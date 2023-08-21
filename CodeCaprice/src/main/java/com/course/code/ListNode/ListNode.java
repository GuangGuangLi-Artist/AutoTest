package com.course.code.ListNode;

public class    ListNode {
    //节点的值
    int val;

    //下一个节点
    ListNode next;

    //节点的构造参数
    public ListNode() {

    }

    //带参构造
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}
