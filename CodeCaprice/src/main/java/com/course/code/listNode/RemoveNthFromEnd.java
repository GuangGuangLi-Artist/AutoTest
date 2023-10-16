package com.course.code.listNode;


/**
 * 19 删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5]
 * 输入：head = [1], n = 1 输出：[]
 * 输入：head = [1,2], n = 1 输出：[1]
 */
public class RemoveNthFromEnd {

    /**
     * 双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，直到fast指向链表末尾。删掉slow所指向的节点就可以了。
     * 1 定义fast指针和slow指针，初始值为虚拟头结点
     * 2 fast首先走n + 1步 ，为什么是n+1呢，因为只有这样同时移动的时候slow才能指向删除节点的上一个节点（方便做删除操作）
     * 3 fast和slow同时移动，直到fast指向末尾
     * 4 删除slow指向的下一个节点
     *
     */

    public static void main(String[] args) {

    }

    public ListNode removeNth(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode fastIndex = dummyHead;
        ListNode slowIndex = dummyHead;

        //只要快慢指针相差n个节点即可
        for (int i = 0; i < n; i++) {
            fastIndex = fastIndex.next;
        }

        while (fastIndex.next != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;


        }

        //此时slowIndex的位置就是待删除元素的前一个位置
        //具体情况可以画一个链表长度为3的图来模拟代码

        slowIndex.next = slowIndex.next.next;
        return  dummyHead.next;
    }

}
