package com.eert1.learn_springboot.Service;

import com.eert1.learn_springboot.pojo.Blog;
import org.apache.ibatis.annotations.Select;

import javax.xml.soap.Text;
import java.util.Date;
import java.util.List;

public interface BlogService {
    public List<Blog> SelectAllBlog();
    public List SelectMostLike();
    public void addBlog(String title, Text content, String poster, String image,int posterId);
}
