package com.eert1.learn_springboot.web;

import com.eert1.learn_springboot.Service.BlogService;
import com.eert1.learn_springboot.Service.UserService;
import com.eert1.learn_springboot.pojo.Blog;
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
    @Autowired
    UserService userService;
    public void initSession(HttpServletRequest request, HttpSession session)
    {
        System.out.println("initSession");
        session=request.getSession();
        session.setAttribute("username",111);
    }
    @GetMapping("/QueryAllBlog")
    public List<Blog> QueryBlog(HttpServletResponse response) throws IOException {
        List<Blog> blogs = blogService.SelectAllBlog();
//        response.getWriter().write(blogs);
        System.out.println(blogs);

//        response.getWriter().write("true");
        return blogs;
    }
    @GetMapping("/QueryFavorite")
    public List Query2(HttpServletResponse response) throws IOException {
        List titles =blogService.SelectMostLike();
        System.out.println(titles);
//        String ti=(String) titles;
//        response.getWriter().write(titles);
        return blogService.SelectMostLike();
    }
    @PostMapping("/postblog")
    public String postBlog(

                           HttpSession session,
                           @RequestBody Map<String,Object> map, HttpServletRequest request)
    {
        String title =(String) map.get("title");
        String content =(String)map.get("content");
        String image=(String)map.get("image");
        String posterName= (String) session.getAttribute("username");
//        System.out.println(posterName);
        posterName="123";
        if (posterName==null)
            return "false";
        else {
            User postid;
//            System.out.println(userService);
//            System.out.println(userService.SelectUser("123"));
            postid=userService.SelectUser(posterName);
            System.out.println(postid);

//            blogService.addBlog(title,content,posterName,image,11);
//            System.out.println(posterName);
//            System.out.println(postid);
//            System.out.println(postid.id);
            blogService.addBlog(title,content,posterName,image,postid.getId());
            return "true";
        }

    }
}
