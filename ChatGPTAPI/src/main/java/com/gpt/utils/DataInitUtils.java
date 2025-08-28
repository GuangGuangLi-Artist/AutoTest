
package com.gpt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataInitUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static void initData(String sql) {
        execute(sql);
    }

    public static void clearData(String sql) {
        execute(sql);
    }

    private static void execute(String sql) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException("执行数据初始化或清理失败：" + e.getMessage(), e);
        }
    }
}
