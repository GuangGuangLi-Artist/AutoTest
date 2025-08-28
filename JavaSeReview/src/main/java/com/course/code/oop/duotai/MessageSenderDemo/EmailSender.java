package com.course.code.oop.duotai.MessageSenderDemo;


//实现类
public class EmailSender implements MessgerSender{


    @Override
    public void send(String to, String message) {
        System.out.println("发送邮件给 " + to + "，内容：" + message);
    }
}
