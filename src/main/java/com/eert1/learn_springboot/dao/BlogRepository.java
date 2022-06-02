package com.eert1.learn_springboot.dao;

import com.eert1.learn_springboot.pojo.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import javax.xml.soap.Text;
import java.util.List;
@Component
@Mapper
public interface BlogRepository {

    @Select("select * from tb_blog")
    List<Blog> SearchAllBlog();
    @Select("Select title from tb_blog where limit 10 order by likes")
    List<String> MostLikes();
    @Insert("Insert into tb_blog values(null,#{title},{content},#{poster},null,#{postTime}，#{image},#{posterId})")
    void addBlog(@Param("title") String title,
                 @Param("content")Text content,
                 @Param("poster")String poster,
                 @Param("postTime")String postTime,
                 @Param("image")String image,
                 @Param("posterId")int posterId);
}
