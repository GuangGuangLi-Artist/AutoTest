package com.course.code.timeTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeOption {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        //2026-03-12T22:41:24.372359100
        System.out.println(localDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatted = localDateTime.format(formatter);
        //2026-03-12 22:44:00
        System.out.println(formatted);
    }
}
