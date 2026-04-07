package codesuixiang.link;

import org.testng.annotations.Test;

/**
 * 19.删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5]
 */
public class Lee_19 {

    @Test
    public void testRemove(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        ListNode afr = removeNthFromEnd(head,n);
        ListNode cur = afr;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

    }

    //双指针

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //新建一个虚拟头节点指向head
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        //快慢指针指向虚拟头节点
        ListNode fast = dummy;
        ListNode slow = dummy;
        //只要快慢指针相差 n 个结点即可
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 此时 slowIndex 的位置就是待删除元素的前一个位置。
        // 具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        // 检查 slowIndex.next 是否为 null，以避免空指针异常
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }
}
