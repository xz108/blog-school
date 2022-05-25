package com.eert1.learn_springboot.dao;

import com.eert1.learn_springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {


    @Select("select * from db_user where username =#{username}")
    User selectByUser(String username);
}
