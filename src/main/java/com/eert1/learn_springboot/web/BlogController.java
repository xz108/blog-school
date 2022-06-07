package com.eert1.learn_springboot.web;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.eert1.learn_springboot.Service.BlogService;
import com.eert1.learn_springboot.Service.UserService;
import com.eert1.learn_springboot.pojo.Blog;
import com.eert1.learn_springboot.pojo.Image;
import com.eert1.learn_springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.soap.Text;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
//@Controller
@RequestMapping(value = "/Blog",produces = "application/json")
public class BlogController {
    @Autowired
    BlogService blogService;

    List<Blog> blogslist;
    @Autowired
    UserService userService;
    public void initSession(HttpServletRequest request, HttpSession session)
    {
        System.out.println("initSession");
        session=request.getSession();
        session.setAttribute("username",111);
    }
    @PostMapping("/QueryAllBlog")
    public List<Blog> QueryBlog(HttpServletResponse response) throws IOException {
        List<Blog> blogs = blogService.SelectAllBlog();
        for (Blog b:
             blogs) {
            b.imageList=JSONUtil.toList(JSONUtil.parseArray(b.image), String.class);
        }


        System.out.println(JSONUtil.toList(JSONUtil.parseArray("[\"12\", \"asd\", \"sad\"]"), String.class));

        return blogs;
    }

    @PostMapping("/QueryAllTopBlog")
    public List<Blog> QueryTopBlog(HttpServletResponse response) throws IOException {
        List<Blog> blogs = blogService.SelectAllTopBlog();
        for (Blog b:
             blogs) {b.imageList=JSONUtil.toList(JSONUtil.parseArray(b.image),String.class);

        }
        return blogs;
    }
    @PostMapping("/GetUserblog")
    public List<Blog> GetUserBlog(@RequestBody Map<String,Object>map)
    {
        List<Blog> blogs= blogService.GetAllBlogByName((String) map.get("username"));
//        List<Blog> blogs = blogService.SelectAllBlog();
        for (Blog b:
                blogs) {
            b.imageList=JSONUtil.toList(JSONUtil.parseArray(b.image), String.class);
        }
        return blogs;
    }

    @PostMapping("/QueryFavorite")
    public List<Blog> Query2(HttpServletResponse response) throws IOException {
        List<Blog> titles =blogService.SelectMostLike();
        System.out.println(titles);
        return blogService.SelectMostLike();
    }
    @PostMapping("/searchBlog")
    public List<Blog> SearchBlog(@RequestBody Map<String,Object>map)
    {
        List<Blog>blogs= blogService.SearchBlog((String) map.get("key"));
//        List<Blog> blogs = blogService.SelectAllBlog();
        for (Blog b:
                blogs) {
            b.imageList=JSONUtil.toList(JSONUtil.parseArray(b.image), String.class);
        }
        return blogs;
    }

    @PostMapping("/postblog")
    public String postBlog(

                           HttpSession session,
                           @RequestBody Map<String,Object> map, HttpServletRequest request)
    {
        String title =(String) map.get("title");
        String content =(String)map.get("content");
        List<Image> image=(List) map.get("image");
        String avatar =(String)map.get("avatar");
        String posterName= (String)map.get("posterName");
        if (posterName==null)
            return "false";
        else {
            User postid;
            postid=userService.SelectUser(posterName);
            System.out.println(postid);
            if (postid==null)
                return "false";
            System.out.println(image);
            String Json;
//            List<Image> images;
            System.out.println(image);
            Json= JSON.toJSONString(image);
            System.out.println(Json);
            blogService.addBlog(title,content,posterName,Json,postid.getId(),avatar);
            return "true";
        }
    }
    @PostMapping("/selectOne")
    public Blog GetBlog(@RequestBody Map<String,Object>map)
    {   Blog blog;
        String type =(String)map.get("type");
        if(type.equals("normal"))
            blog =blogService.getOneBlog((Integer)map.get("id"));
        else
            blog=blogService.getOneTopBlog((Integer)map.get("id"));
        if(blog==null)
            return null;
        blog.imageList=JSONUtil.toList(JSONUtil.parseArray(blog.image),String.class);
        return blog;
    }
}
