package codesuixiang.link;

/**
 * 203 移除链表元素
 * 题意：删除链表中等于给定值 val 的所有节点
 * 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
 */
public class Lee_203 {


    /**
     * 虚拟头节点方式
     */
    public static ListNode removeElements(ListNode head, int val) {
        //设置一个虚拟的头节点
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
