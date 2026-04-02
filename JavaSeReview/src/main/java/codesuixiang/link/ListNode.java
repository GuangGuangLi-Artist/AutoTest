package codesuixiang.link;

public class ListNode {

    int val;
    ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }


    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
