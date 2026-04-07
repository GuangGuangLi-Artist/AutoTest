package codesuixiang.link;

import org.testng.annotations.Test;

/**
 * 反转链表
 * 题意：反转一个单链表。
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */
public class Lee_206 {

    @Test
    public void testReverse(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode afR = reverseList(head);
        ListNode cur = afR;
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
    //双指针

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;// 保存cur的下一个节点

        while(cur != null) {
            temp = cur.next; // 保存一下 cur的下一个节点，因为接下来要改变cur->next
            cur.next = prev; // 翻转操作
            // 更新pre 和 cur指针
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
