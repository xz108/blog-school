package com.eert1.learn_springboot.dao;

import com.eert1.learn_springboot.pojo.User;
import org.apache.ibatis.annotations.*;
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

    @Insert("insert into db_user values(null,#{username},#{password},'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png')")
    void insertUser(@Param("username") String username,@Param("password") String password);

    @Update("update db_user set avater=#{avatar},username=#{newU} where username=#{oldU};")
    int UpdateUser(@Param("avatar") String avatar,
               @Param("newU") String newU,
               @Param("oldU") String oldU);

    @Update("update comment set avatar=#{avatar},nickname=#{newU} where nickname=#{oldU};")
    int UpdateUserComment(@Param("avatar") String avatar,
                   @Param("newU") String newU,
                   @Param("oldU") String oldU);
    @Update("update top_comment set avatar=#{avatar},nickname=#{newU} where nickname=#{oldU};")
    int UpdateUserTopComment(@Param("avatar") String avatar,
                          @Param("newU") String newU,
                          @Param("oldU") String oldU);

    @Update("update db_blog set avatar=#{avatar},poster=#{newU} where poster=#{oldU};")
    int UpdateUserBlog(@Param("avatar") String avatar,
                             @Param("newU") String newU,
                             @Param("oldU") String oldU);
    @Update("update db_top set avatar=#{avatar},poster=#{newU} where poster=#{oldU};")
    int UpdateUserBlogTop(@Param("avatar") String avatar,
                       @Param("newU") String newU,
                       @Param("oldU") String oldU);

    @Update("update goods set avatar=#{avatar},seller=#{newU} where seller=#{oldU};")
    int UpdateUserGood(@Param("avatar") String avatar,
                       @Param("newU") String newU,
                       @Param("oldU") String oldU);
    @Update("update team set leader_avatar=#{avatar},leader=#{newU} where leader=#{oldU};")
    int UpdateUserTeam(@Param("avatar") String avatar,
                       @Param("newU") String newU,
                       @Param("oldU") String oldU);
    @Update("update team_members set avatar=#{avatar},memberName=#{newU} where memberName=#{oldU};")
    int UpdateUserTeamM(@Param("avatar") String avatar,
                       @Param("newU") String newU,
                       @Param("oldU") String oldU);
}
