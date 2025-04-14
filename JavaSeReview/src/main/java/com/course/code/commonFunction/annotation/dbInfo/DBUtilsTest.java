package com.course.code.commonFunction.annotation.dbInfo;

import java.sql.Connection;

public class DBUtilsTest {
    public static void main(String[] args) {
        Connection conn = DBUtils.getMyConnection();
        System.out.println(conn);
    }
}
