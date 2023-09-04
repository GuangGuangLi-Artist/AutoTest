package com.course.code.ListNode;


/**
 * 206 反转链表
 *     反转一个单链表。
 *     输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {

//    双指针法
    /**
     * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0206.%E7%BF%BB%E8%BD%AC%E9%93%BE%E8%A1%A8.md
     * 首先定义一个cur指针，指向头结点，再定义一个pre指针，初始化为null。
     * 然后就要开始反转了，首先要把 cur->next 节点用tmp指针保存一下，也就是保存一下这个节点。
     * 为什么要保存一下这个节点呢，因为接下来要改变 cur->next 的指向了，将cur->next 指向pre ，此时已经反转了第一个节点了。
     * 接下来，就是循环走如下代码逻辑了，继续移动pre和cur指针。
     * 最后，cur 指针已经指向了null，循环结束，链表也反转完毕了。 此时我们return pre指针就可以了，pre指针就指向了新的头结点。
     */


    public static void main(String[] args) {

    }

//    双指针法
    public static ListNode reverseList(ListNode head) {
        ListNode  prev = null;  //前面的节点
        ListNode cur = head;//指向头节点
        ListNode tem = null;//定义一个临时节点
        while (cur != null) {
            tem = cur.next;//提前给当前节点的下一个节点赋值给临时节点存起来
            cur.next = prev;//反转节点 指向
            prev = cur;//先移动节点到原先的cur节点的位置
            cur = tem;//将cur节点移动到tem临时节点
        }
        return prev;
    }

    //递归方法
    public static ListNode reverseListDiGui(ListNode head) {
        return reverse(null,head);
    }

    private static ListNode reverse(ListNode prev, ListNode cur) {
        if(cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;
        cur.next = prev;
        /**
         * 更新prev,cur位置
         * prev = cur
         * cur = temp
         */
        return reverse(cur,temp);
    }
}
