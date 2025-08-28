package com.course.code.oop.duotai.MessageSenderDemo;

public class testMessgerSender {

    public static void main(String[] args) {
        NotificationService emialService = new NotificationService(new EmailSender());
        emialService.notifyUser("alice@example.com", "欢迎注册！");

        NotificationService smsService = new NotificationService(new SmsSender());
        smsService.notifyUser("13812345678", "验证码是 123456");


        NotificationService weChatService = new NotificationService(new WeChatSender());
        weChatService.notifyUser("AliceWeChatID", "您的订单已发货");
    }




}
