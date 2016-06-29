package com.chaoxu;

import com.chaoxu.mapper.UserMapper;
import com.chaoxu.pojo.User;
import com.chaoxu.util.BatisUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/6/28.
 */
public class BatismappertestCase {
    private Logger logger = LoggerFactory.getLogger(BatismappertestCase.class);

    @Test
    public void testfindbyid() {

        SqlSession sqlSession = BatisUtil.getSqlSession();
        //getMapper()方法使用了【动态代理模式】-> 自动产生一个接口的实现类
        UserMapper userMapperr = sqlSession.getMapper(UserMapper.class);

        User user = userMapperr.findByid(6);

        logger.debug("查询单个用户{}:", user);
        sqlSession.close();

//=====================================================

        SqlSession sqlSession2 = BatisUtil.getSqlSession();
        UserMapper userMapperr2 = sqlSession2.getMapper(UserMapper.class);

        User user2 = userMapperr2.findByid(6);


        logger.debug("查询单个用户222{}:", user2);
        sqlSession2.close();

    }

    @Test
    public void testadduser() {
        SqlSession sqlSession = BatisUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User("瑞霞", "晶");
        userMapper.addUser(user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testdeluser() {
        SqlSession sqlSession = BatisUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.delUser(24);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testfindAll() {

        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = userMapper.findAll();

        for (User user : list) {
            logger.debug("user:::!!!!:::{}", user);
        }
    }

    @Test
    public void testfindByMap() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "瑞霞");
        map.put("password", "晶");
        User user = userMapper.findByMap(map);
        logger.debug("Map查询{}:", user);
    }

    @Test
    public void testfindByparam() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findByparam("瑞霞", "晶");

        //User user = userMapper.findByparam("瑞霞", "晶");
        logger.debug("Map的另一种查询{}:", user);
    }

    @Test
    public void testAdduser() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User("赵玉萍", "0513");
        userMapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testupuser() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findByid(9);
        user.setUsername("牛丽娟");
        user.setPassword("love");

        userMapper.upUser(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQueryMap() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = Maps.newHashMap();
        map.put("password", "love");
        map.put("username", "牛丽娟");
        map.put("password", "zcx031428");
        List<User> list = userMapper.findByQueryMap(map);
        for (User user : list) {
            logger.debug("结果查询的数据{}:", list);
        }
        Assert.assertNotNull(list);
        sqlSession.close();
    }

    @Test
    public void testBathSave() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = Lists.newArrayList();

        list.add(new User("江流儿", "007"));
        list.add(new User("孙猴子", "888"));
        list.add(new User("猪无能", "000"));
        list.add(new User("沙悟净", "009"));
        userMapper.BathSave(list);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void tsetfindBYID() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> idlist = Lists.newArrayList(3, 6, 9);

        List<User> userList = userMapper.findBYID(idlist);
        Assert.assertNotNull(userList);
        for (User user : userList) {
            logger.debug("{}->", user);
        }
    }

    @Test
    public void testfindbylimit(){
        SqlSession sqlSession = BatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //List<Integer> list = Lists.newArrayList(1,6);

        List<User> userList = userMapper.findBypage(1,6);
        logger.debug("分页查询{}",userList);
        sqlSession.close();
    }
}
