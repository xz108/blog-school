package com.eert1.learn_springboot.dao;

import com.eert1.learn_springboot.pojo.Blog;
import com.eert1.learn_springboot.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentRepository {
    @Insert("insert into comment values(null,#{nickname},#{content},#{avatar},#{create_time},#{blog_id},#{title})")
    int postComment(@Param("nickname")String nickname,
                    @Param("content")String content,
                    @Param("avatar")String avatar,
                    @Param("create_time")String create_time,
                    @Param("blog_id")int blog_id,
                    @Param("title")String title);
    @Select("select * from comment where blog_id=#{blog_id}")
    List<Comment> SelectAllComment(int blog_id);
    @Select("select * from db_blog where id=#{id}")
    Blog SelectPoster(int id);

    @Insert("insert into top_comment values(null,#{nickname},#{content},#{avatar},#{create_time},#{blog_id},#{title})")
    int postTopComment(@Param("nickname")String nickname,
                    @Param("content")String content,
                    @Param("avatar")String avatar,
                    @Param("create_time")String create_time,
                    @Param("blog_id")int blog_id,
                    @Param("title")String title);
    @Select("select * from top_comment where blog_id=#{blog_id}")
    List<Comment> SelectAllTopComment(int blog_id);



}
