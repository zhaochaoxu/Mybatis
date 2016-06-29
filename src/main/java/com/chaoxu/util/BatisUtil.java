package com.chaoxu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by dell on 2016/6/27.
 */
public class BatisUtil {

    private static SqlSessionFactory sqlSessionFactory = BuildSessionFactory();

    private static SqlSessionFactory BuildSessionFactory() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            return sessionFactory;
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }

    public static SqlSessionFactory getsessionFactory(){
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession(){
        return getsessionFactory().openSession();
    }
}
