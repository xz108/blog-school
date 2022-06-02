package com.eert1.learn_springboot.web;

import com.eert1.learn_springboot.Service.BlogService;
import com.eert1.learn_springboot.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.soap.Text;
import java.util.List;

@Controller
@RequestMapping("/Blog")
@CrossOrigin(origins = "*")
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("/QueryAllBlog")
    public List<Blog> QueryBlog()
    {
       return blogService.SelectAllBlog();
    }
    @GetMapping("/QueryFavorite")
    public List Query2()
    {
        return blogService.SelectMostLike();
    }
    @PostMapping("/postblog")
    public String postBlog(@RequestParam("title")String title,
                           @RequestParam("content") Text content,
                           HttpSession session,
                           @RequestParam("image") String image, HttpServletRequest request)
    {
        String posterName= (String) session.getAttribute("username");
        blogService.addBlog(title,content,posterName,image,1);
        image ="1";
        return "blog:"+title;
    }
}
