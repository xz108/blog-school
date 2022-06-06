package com.eert1.learn_springboot.dao;

import com.eert1.learn_springboot.pojo.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.xml.soap.Text;
import java.util.List;
@Repository("BlogRepository")
@Mapper
public interface BlogRepository {

    @Select("select * from db_blog")
    List<Blog> SearchAllBlog();

    @Select("select * from db_blog where id=#{id}")
    Blog SearchOneBlog(int id);

    @Select("select * from db_blog where poster=#{username}")
    List<Blog> GetAllBlogByName(String username);

    @Select("select * from db_top")
    List<Blog> SearchAllTopBlog();

    @Insert("Insert into db_top values(null,#{title},#{content},#{poster},null,#{postTime},#{image},#{posterId})")
    void addTopBlog(@Param("title") String title,
                 @Param("content") String content,
                 @Param("poster")String poster,
                 @Param("postTime")String postTime,
                 @Param("image")String image,
                 @Param("posterId")int posterId);

    @Select("select * from db_blog where title like  concat('%',#{key},'%')")
    List<Blog> SearchBlog(String key);

    @Select("Select title from(select * from db_blog order by likes) db_blog  limit 10")
    List<String> MostLikes();
    @Insert("Insert into db_blog values(null,#{title},#{content},#{poster},null,#{postTime},#{image},#{posterId})")
    void addBlog(@Param("title") String title,
                 @Param("content") String content,
                 @Param("poster")String poster,
                 @Param("postTime")String postTime,
                 @Param("image")String image,
                 @Param("posterId")int posterId);


}
