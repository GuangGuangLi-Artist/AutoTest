package com.course.code.commonFunction.annotation.dbInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtilsTest {
    public static void main(String[] args) {
        Connection conn = DBUtils.getMyConnection();
        try {
            PreparedStatement select = conn.prepareStatement("select  count(*) from orders where cust_id = '10001';");
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
            select.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(conn);
    }
}
