package niukeans;

import java.util.Scanner;

public class HJ51 {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            int n = sc.nextInt();//8个数

            //构建链表
            ListNode head = null;
            ListNode tail = null;

            for (int i = 0; i < n; i++){
                int val = sc.nextInt();
                ListNode newNode = new ListNode(val);

                if (head == null){
                    head = newNode;
                    tail = newNode;
                }else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }

            int k = sc.nextInt();

            ListNode fast = head;
            ListNode slow = head;

            //fast先走k步
            for (int i = 0; i < k; i++){
                if (fast == null){
                    break;
                }
                fast = fast.next;
            }

            while (fast != null){
                fast = fast.next;
                slow = slow.next;
            }

            //slow现在指向倒数第k个结点
            System.out.println(slow.val);


        }

    }
}
