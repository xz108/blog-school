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
        String nickname=(String) map.get("username");
        String content =(String)map.get("content");
        String avatar =(String) map.get("avatar");
        String bid =(String)map.get("blog_id");
        Integer blog_id=Integer.parseInt(bid);
        System.out.println(blog_id);
        if(commentService.postComment(nickname,content,avatar,blog_id)==1)
            return true;
        else return false;
    }
    @PostMapping("/listAllComment")
    public List<Comment> getComment(@RequestBody Map<String,Object>map)
    {
        String blog_id =(String) map.get("blog_id");
        Integer bg1=Integer.parseInt(blog_id);
        System.out.println(bg1);
        return commentService.selectAllComment(bg1);
    }

}
