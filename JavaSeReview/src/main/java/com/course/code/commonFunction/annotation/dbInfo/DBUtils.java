package com.course.code.commonFunction.annotation.dbInfo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

@DBInfo
public class DBUtils {
    private static final Properties PROPERTIES = new Properties();
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static {
        Class<DBUtils> dbUtilsClass = DBUtils.class;
        boolean present = dbUtilsClass.isAnnotationPresent(DBInfo.class);
        if (present) {
            DBInfo dbInfo = dbUtilsClass.getAnnotation(DBInfo.class);
            System.out.println(dbInfo.username());
            driver = dbInfo.driver();
            url = dbInfo.url();
            user = dbInfo.username();
            password = dbInfo.password();

        }else {
            InputStream inputStream = DBUtils.class.getResourceAsStream("db.properties");
            try {
                PROPERTIES.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getMyConnection() {

        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void close(Connection conn, Statement statement, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }

            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
