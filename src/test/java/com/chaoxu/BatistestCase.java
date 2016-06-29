package com.chaoxu;

import com.chaoxu.pojo.User;
import com.chaoxu.util.BatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by dell on 2016/6/27.
 */
public class BatistestCase {
    private Logger logger = LoggerFactory.getLogger(BatistestCase.class);

    @Test
    public void testjdbc() {


        try {
            Reader reder = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reder);
            SqlSession session = sessionFactory.openSession();

            User u = session.selectOne("com.mapper.UserMapper.findByid");
            logger.debug("用户{}:", u);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testfindAll() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        List<User> list = sqlSession.selectList("com.chaoxu.mapper.UserMapper.findAll");    //.selectList("com.mapper.UserMapper.findAll");

        for (User user : list) {
            logger.debug("用户的数据{}::", user);
        }
        //Assert.assertNotNull(list);
        sqlSession.close();
    }

    @Test
    public void testAdduser() {
        SqlSession sqlsession = BatisUtil.getSqlSession();
        User user = new User("宋妈妈", "我的牵挂");
        sqlsession.insert("com.chaoxu.mapper.UserMapper.addUser", user);
        sqlsession.commit();
        sqlsession.close();
    }


    @Test
    public void testdeluser() {
        SqlSession sqlsession = BatisUtil.getSqlSession();
        sqlsession.delete("com.chaoxu.mapper.UserMapper.delUser",17);
        sqlsession.commit();
        sqlsession.close();
    }


    @Test
    public void testupuser(){

        SqlSession sqlsession = BatisUtil.getSqlSession();
        User user = sqlsession.selectOne("com.chaoxu.mapper.UserMapper.findByid",5);
        logger.debug("查找用户{}：",user);

        user.setUsername("铁树开花");
        user.setPassword("love520");

        sqlsession.update("com.chaoxu.mapper.UserMapper.upUser",user);

        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void testfindbyid(){
        SqlSession sqlsession = BatisUtil.getSqlSession();
        User user = sqlsession.selectOne("com.chaoxu.mapper.UserMapper.findByid",6);
        logger.debug("单个用户{}:",user);
        Assert.assertNotNull(user);
        sqlsession.close();
    }

    /*@Test
    public void testJiekou(){
        SqlSession sqlSession = BatisUtil.getSqlSession();
        //UserMapper useremapper
    }*/
}
