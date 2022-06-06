package com.eert1.learn_springboot.Service.impl;

import com.eert1.learn_springboot.Service.BlogService;
import com.eert1.learn_springboot.dao.BlogRepository;
import com.eert1.learn_springboot.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class BlogServiceimpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> SelectAllBlog() {
         List<Blog> blogs =blogRepository.SearchAllBlog();
         return blogs;
    }

    @Override
    public List<Blog> SelectAllTopBlog() {
        List<Blog> blogs =blogRepository.SearchAllBlog();
        return blogs;
    }

    @Override
    public List<Blog> SearchBlog(String key) {
        return blogRepository.SearchBlog(key);
    }

    @Override
    public List<Blog> GetAllBlogByName(String username) {
        return blogRepository.GetAllBlogByName(username);
    }

    @Override
    public Blog getOneBlog(int id) {
        return blogRepository.SearchOneBlog(id);
    }

    @Override
    public List SelectMostLike() {
         List titles =blogRepository.MostLikes();
         return titles;
    }

    @Override
    public void addBlog(String title, String content, String poster, String image, int posterId) {
        Date date = new Date();
//        System.out.printf();
        SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowDate= sf.format(date);
        System.out.println(nowDate);
//        System.out.println(date.getTime());
        blogRepository.addBlog(title,content,poster,nowDate,image,posterId);
    }


}
