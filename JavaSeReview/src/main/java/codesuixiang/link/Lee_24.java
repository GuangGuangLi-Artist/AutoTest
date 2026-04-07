package codesuixiang.link;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 输入 head = [1,2,3,4]
 * 输出 [2,1,4,3]
 */
public class Lee_24 {


    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);// 设置一个虚拟头结点
        dummy.next = head;// 将虚拟头结点指向head，这样方便后面做删除操作
        ListNode cur = dummy;

        ListNode temp = null;// 临时节点，保存两个节点后面的节点
        ListNode first = null;// 临时节点，保存两个节点之中的第一个节点
        ListNode second = null;// 临时节点，保存两个节点之中的第二个节点

        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            first = cur.next;
            second = cur.next.next;

            cur.next = second;// 步骤一
            second.next = first;// 步骤二
            first.next = temp; // 步骤三
            cur = first;// cur移动，准备下一轮交换
        }
        return dummy.next;
    }

}
