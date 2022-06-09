package com.eert1.learn_springboot.web;

import com.eert1.learn_springboot.Service.CommentService;
import com.eert1.learn_springboot.pojo.Blog;
import com.eert1.learn_springboot.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping("/postComment")
    public boolean postComment(@RequestBody Map<String,Object>map)
    {
        String nickname=(String) map.get("nickname");
        String content =(String)map.get("content");
        String avatar =(String) map.get("avatar");
        Integer bid =(Integer)map.get("blog_id");
        System.out.println(bid);
        if(commentService.postComment(nickname,content,avatar,bid)==1)
            return true;
        else return false;
    }
    @PostMapping("/listAllComment")
    public List<Comment> getComment(@RequestBody Map<String,Object>map)
    {
        Integer blog_id =(Integer) map.get("blog_id");
        System.out.println(blog_id);
        List<Comment> comments = commentService.selectAllComment(blog_id);
        System.out.println(comments);
        return commentService.selectAllComment(blog_id);
    }
    @PostMapping("/postTopComment")
    public boolean postTopComment(@RequestBody Map<String,Object>map)
    {
        String nickname=(String) map.get("nickname");
        String content =(String)map.get("content");
        String avatar =(String) map.get("avatar");
        Integer blog_id =(Integer)map.get("blog_id");
        System.out.println(blog_id);
        if(commentService.postTopComment(nickname,content,avatar,blog_id)==1)
            return true;
        else return false;
    }
    @PostMapping("/listAlltopComment")
    public List<Comment> getTopComment(@RequestBody Map<String,Object>map)
    {
        Integer blog_id =(Integer) map.get("blog_id");
        System.out.println(blog_id);
        return commentService.selectAllTopComment(blog_id);
    }

}
