package codesuixiang.link;

import org.testng.annotations.Test;

/**
 * 203 移除链表元素
 * 题意：删除链表中等于给定值 val 的所有节点
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 */
public class Lee_203 {


    @Test
    public void testRemove(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        int val = 6;

        ListNode afterRemove = removeElements(head, val);

        ListNode cur = afterRemove;
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }


    /**
     * 虚拟头节点方式
     */
    public  static ListNode removeElements(ListNode head, int val) {
        //定义虚拟头节点
        ListNode dummy = new ListNode();
        //虚拟头节点指向头节点
        dummy.next = head;

        //定义当前节点 当前节点为虚拟头节点
        ListNode cur = dummy;
        // 遍历寻找值
        while (cur.next != null) {
            if(cur.next.val == val){//值为目标值
                cur.next = cur.next.next;//指向目标值的下一个节点
            }else {
                cur = cur.next;//不是目标值，更新指向
            }
        }
        return dummy.next;
    }

}
