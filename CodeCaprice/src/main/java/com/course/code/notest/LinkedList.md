### 链表
    [1]: 什么是链表，链表是一种通过指针串联在一起的线性结构，每一个节点由两部分组成，
      一个是数据域一个是指针域（存放指向下一个节点的指针），最后一个节点的指针域指向null（空指针的意思）。
      链表的入口节点称为链表的头结点也就是head。
    [2]:  单链表 双链表 循环链表
    [3]: 链表的长度可以是不固定的，并且可以动态增删， 适合数据量不固定，频繁增删，较少查询的场景。

```java
public class ListNode {
    //节点的值
    int val;
    
    //下一个节点
    ListNode next;
    
    //节点的构造参数
    public ListNode() {
        
    }
    
    //带参构造
    public ListNode(int val) {
        this.val = val;
    }
    
    public ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}
```


