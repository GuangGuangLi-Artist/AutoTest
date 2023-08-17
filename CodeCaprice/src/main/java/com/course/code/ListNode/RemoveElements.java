package com.course.code.ListNode;


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
