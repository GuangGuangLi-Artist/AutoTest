package com.course.code.oop.duotai.MessageSenderDemo;

public class SmsSender implements MessgerSender{
    @Override
    public void send(String to, String message) {
        System.out.println("发送短信给 " + to + "，内容：" + message);
    }
}
