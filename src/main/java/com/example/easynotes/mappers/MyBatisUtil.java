package com.example.easynotes.mappers;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static SqlSessionFactory sessionFactory;
//
//    static {
//        Reader reader;
//
//        try {
//            reader = Resources.getResourceAsReader("resources/mybatis-config.xml");
//            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//
//            System.out.println("READER: " + reader.toString());
//            //System.out.println("SQL SESSION FACTORY: " + .toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static SqlSessionFactory getSessionFactory() {
        Reader reader;

        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);

            System.out.println("READER: " + reader.toString());
            System.out.println("SQL SESSION FACTORY: " + sessionFactory.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return sessionFactory;
    }
}
