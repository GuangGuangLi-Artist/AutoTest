package com.course.code.oneThree;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import org.testng.annotations.Test;

import java.util.Iterator;

public class oneBagQueueStack {


    @Test
    public void testBag(){
        //创建一个背包
        Bag<String> bag = new Bag<>();

        //bag中添加元素
        bag.add("李广");
        bag.add("苏彪");
        bag.add("苏飞");

        //判断bag是否为空
        StdOut.println(bag.isEmpty());

        //读取bag的大小
        StdOut.println(bag.size());

        //取出bag中的内容
        Iterator<String> bagiterator = bag.iterator();
        while (bagiterator.hasNext()){
            StdOut.println(bagiterator.next());
        }

    }

    @Test
    public void testQueue(){
        Queue<Student> queue = new Queue();
        Student s1 = new Student("liguang","男",23,18000.20);
        Student s2 = new Student("苏表","男",22,17000.20);
        Student s3 = new Student("陈红","女",18,15000.20);

        //添加元素
        queue.enqueue(s1);
        queue.enqueue(s2);
        queue.enqueue(s2);
        queue.enqueue(s3);

        //判断是否为空
        StdOut.println(queue.isEmpty());

        //获取长度
        StdOut.println(queue.size());

        //取出队列中的值
        Iterator<Student> studentIterator = queue.iterator();
        while (studentIterator.hasNext()){
            Student student = studentIterator.next();
            StdOut.println(student);
        }

        //删除最早添加的数据  先进先出
        StdOut.println(queue.toString());
        queue.dequeue();
        StdOut.println(queue.toString());



    }

    @Test
    public void testStatck(){

        //创建栈
        Stack<Student>  stack = new Stack<>();

        //向栈添加值
        stack.push(new Student("liguang","男",23,18000.20));
        stack.push(new Student("苏表","男",22,17000.20));
        stack.push(new Student("苏蓉","女",15,17000.20));
        stack.push(new Student("陈红","女",18,15000.20));

        //判断栈是否为空
        StdOut.println(stack.isEmpty());

        //栈的大小
        StdOut.println(stack.size());

        //创建迭代器
        Iterator<Student> studentIterator = stack.iterator();
        for (Student s: stack){
            StdOut.println(s);
        }

        //删除最近添加的元素 后进先出
        StdOut.println(stack.toString());
        Student studentpop = stack.pop();
        StdOut.println("弹出的元素是:" + studentpop.toString());
        StdOut.println(stack);


    }
}
