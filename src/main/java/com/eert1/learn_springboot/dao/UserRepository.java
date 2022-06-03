package com.eert1.learn_springboot.dao;

import com.eert1.learn_springboot.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("UserRepository")
public interface UserRepository {

    @Select("select * from db_user where username =#{username}")
    User selectByUser(String username);

    @Select("select * from db_user where username =#{username} and password=#{password}")
    User selectByUserAndPassword(@Param("username") String username,@Param("password") String password);

    @Select("select * from db_user where username =#{username}")
    User selectIdByName(@Param("username") String username);

    @Insert("insert into db_user values(null,#{username},#{password},null)")
    void insertUser(@Param("username") String username,@Param("password") String password);

}
