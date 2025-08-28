
package com.gpt.utils;

import java.sql.*;

public class DbAssertUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static boolean assertExists(String sql) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.next();
        } catch (Exception e) {
            throw new RuntimeException("数据库断言失败：" + e.getMessage(), e);
        }
    }
}
