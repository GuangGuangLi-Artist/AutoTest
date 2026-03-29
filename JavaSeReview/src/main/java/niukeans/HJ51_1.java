package niukeans;


import java.util.Scanner;

/**
 * 链表使用虚拟头节点
 */
public class HJ51_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            // 1. 构建链表
            // 使用虚拟头节点构建，方便后续操作（虽然本题只读，但这是好习惯）
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                tail.next = new ListNode(val);
                tail = tail.next;
            }

            int k = sc.nextInt();

            // 2. 双指针查找倒数第 k 个节点
            // 关键点：fast 和 slow 都从 dummy 开始，而不是 head
            ListNode fast = dummy;
            ListNode slow = dummy;

            //fast先走K步
            for (int i = 0; i < k; i++) {
                // 题目保证 k <= n，所以 fast 不会变成 null，但为了健壮性可以加判断
                if (fast != null) {
                    fast = fast.next;
                }
            }

            // fast 和 slow 同时移动，直到 fast 到达末尾 (null)
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // 此时 slow 指向的就是倒数第 k 个节点
            System.out.println(slow.val);

        }


    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }



}
