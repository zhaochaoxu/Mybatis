package com.chaoxu;


import com.chaoxu.mapper.TopicMapper;
import com.chaoxu.pojo.Tag;
import com.chaoxu.pojo.Topic;
import com.chaoxu.pojo.Tuser;
import com.chaoxu.util.BatisUtil;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by dell on 2016/6/29.
 */
public class TopicMapperteseCase {

    private Logger logger = LoggerFactory.getLogger(TopicMapperteseCase.class);

    @Test
    public void testfindByid() {
        SqlSession sqlSession = BatisUtil.getSqlSession();
        TopicMapper topicMapper = sqlSession.getMapper(TopicMapper.class);

        List<Topic> listtopic = topicMapper.findByid(2);

        for (Topic topic : listtopic) {

            logger.debug("节点的名字->{}", topic.getNode().getNodename());
        }


//        Assert.assertNotNull(topic);

    }

    @Test
    public void testfifndAll(){
        SqlSession sqlSession = BatisUtil.getSqlSession();
        TopicMapper topicMapper = sqlSession.getMapper(TopicMapper.class);

        List<Tuser> userList = topicMapper.findAll();
        for (Tuser user:userList) {
            logger.debug("获取所有标签名字->{}",user.getTag().getTagname());
        }

        /*for (Tag tag:tagList) {
            logger.debug("获取所有标签名字->{}",tag);
        }*/
    }
}
