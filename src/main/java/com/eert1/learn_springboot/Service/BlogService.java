package com.eert1.learn_springboot.Service;

import com.eert1.learn_springboot.pojo.Blog;

import java.util.List;

public interface BlogService {
    public List<Blog> SelectAllBlog();
    public List SelectMostLike();
    public void addBlog(String title, String content, String poster, String image, int posterId);

}
