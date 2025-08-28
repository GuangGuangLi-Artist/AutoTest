package com.course.code.oop.duotai.MessageSenderDemo;

public class WeChatSender  implements MessgerSender{
    @Override
    public void send(String to, String message) {
        System.out.println("发送微信给 " + to + "，内容：" + message);
    }
}
