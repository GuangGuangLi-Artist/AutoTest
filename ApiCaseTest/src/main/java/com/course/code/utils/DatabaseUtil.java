package com.course.code.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {

    public static SqlSession getSqlSession() throws IOException {

        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //factory.openSession(true) 解决了Setting autocommit to false on JDBC Connection
        SqlSession session = factory.openSession(true);


        return session;
    }
}
