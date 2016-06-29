package com.chaoxu.mapper;

import com.chaoxu.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/6/28.
 */
public interface UserMapper {


    void addUser(User user);

    void BathSave(List<User> list);

    /*@Delete("delete from users where id = #{id}")*/
    void delUser(Integer id);

    /*@Update("update users set username = #{username}, password = #{password} where id = #{id}")*/
    void upUser(User user);

    /*@Select("select * from users where id = #{id}")*/
    User findByid(Integer id);

    List<User> findAll();

    User findByMap(Map<String, Object> map);

    User findByparam(String username, String password);

//    User findByparam(@Param("username") String username, @Param("pwd") String password);

    List<User> findByQueryMap(Map<String, Object> map);

    List<User> findBYID(List<Integer> list);

    List<User> findBypage(@Param("start") Integer pagestart, @Param("size") Integer pagesize);
}
