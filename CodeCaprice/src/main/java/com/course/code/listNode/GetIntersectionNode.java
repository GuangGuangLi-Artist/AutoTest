package com.course.code.listNode;


/**
 * 160  链表相交
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 简单来说，就是求两个链表交点节点的指针。 这里同学们要注意，交点不是数值相等，而是指针相等。
 * 为了方便举例，假设节点元素数值相等，则节点指针相等
 * 看如下两个链表，目前curA指向链表A的头结点，curB指向链表B的头结点
 * 我们求出两个链表的长度，并求出两个链表长度的差值，然后让curA移动到，和curB 末尾对齐的位置
 * 此时我们就可以比较curA和curB是否相同，如果不相同，同时向后移动curA和curB，如果遇到curA == curB，则找到交点
 * 否则循环退出返回空指针
 *
 */
public class GetIntersectionNode {

    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA,ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curB.next;

        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        if(lenA > lenB) {
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;

            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;

        }
        int gap = lenA - lenB;
        while (gap --> 0) {
            curA = curA.next;
        }

        while (curA != null) {
            if(curA == curB) {
                return  curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
