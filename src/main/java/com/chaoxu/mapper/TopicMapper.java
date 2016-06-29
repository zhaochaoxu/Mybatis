package com.chaoxu.mapper;

import com.chaoxu.pojo.Tag;
import com.chaoxu.pojo.Topic;
import com.chaoxu.pojo.Tuser;

import java.util.List;

/**
 * Created by dell on 2016/6/29.
 */
public interface TopicMapper {

    List<Topic> findByid(Integer id);

    List<Tuser> findAll();
}
