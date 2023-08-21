package com.course.code.ListNode;


import org.testng.annotations.Test;

/**
 *  203 移除链表元素
 *  题意：删除链表中等于给定值 val 的所有节点。
 *  示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 *  示例 2： 输入：head = [], val = 1 输出：[]
 *  示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]
 */
public class RemoveElements {

    public static void main(String[] args) {

    }


    @Test
    public void testListNode() {
        ListNode nodeSta = new ListNode(0);//创建首节点
        ListNode nextNode;//声明一个变量用来在移动过程中指向当前节点
        nextNode = nodeSta; //指向首节点

        //创建链表
        for (int i = 1; i < 10; i++) {
            ListNode node = new ListNode(i);
            nextNode.next = node;
            nextNode = nextNode.next;
        }

        nextNode = nodeSta;
        print(nextNode);



    }

    public static void print(ListNode listNode) {
        //创建链表节点
        while (listNode != null) {
            System.out.println("listNode:" + listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }


    //添加虚拟节点
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }




}
