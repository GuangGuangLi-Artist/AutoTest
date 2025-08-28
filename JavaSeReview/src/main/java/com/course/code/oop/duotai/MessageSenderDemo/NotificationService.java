package com.course.code.oop.duotai.MessageSenderDemo;

// 使用者类（调用接口，解耦调用方和实现）
public class NotificationService {

    private MessgerSender sender;

    // 构造注入不同的发送器
    public NotificationService(MessgerSender sender) {
        this.sender = sender;
    }
    public void notifyUser(String to, String message) {
        sender.send(to,message); // // 多态：根据实际对象调用对应的 send 方法
    }
}
