package com.course.code.ListNode;


/**
 * 24 两两交换链表中的节点
 *     给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {

    public static void main(String[] args) {

    }

    public static ListNode swapPairsList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);//设置一个虚拟头节点
        dummyHead.next = head;//将虚拟头节点指向head,方便后面做位置交换
        ListNode cur = dummyHead;//当前节点的指针指向虚拟头节点
        ListNode temp;//临时节点 保存两个节点后面的节点
        ListNode firstNode;//临时节点 保存两个节点中的第一个节点
        ListNode secondNode;//临时节点 保存两个节点中的第二个节点
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode; //第一步
            secondNode.next = firstNode;//第二步
            firstNode.next = temp;//第三步
            cur = firstNode;//cur移动 准备下一轮交换
        }
        return dummyHead.next;

    }
}
