package com.eert1.learn_springboot.Service.impl;

import com.eert1.learn_springboot.Service.CommentService;
import com.eert1.learn_springboot.dao.CommentRepository;
import com.eert1.learn_springboot.pojo.Blog;
import com.eert1.learn_springboot.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class CommentServiceimpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public List<Comment> selectAllComment(int blog_id) {
        return commentRepository.SelectAllComment(blog_id);
    }

    @Override
    public int postComment(String nickname, String content, String avatar, int blog_id) {
        Date date = new Date();
//        System.out.printf();
        SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowDate= sf.format(date);
        System.out.println(nowDate);
        String title;
        if(judgeTitle(nickname))
        {
            title="作者";
        }
        else
            title="观众";
        if (commentRepository.postComment(nickname,content,avatar,nowDate,blog_id,title)==1)
        {
            return 1;
        }
        else
            return 0;
    }

    @Override
    public Boolean judgeTitle(String nickname) {
        Blog blog= commentRepository.SelectPoster(nickname);
//        System.out.println();
        if (blog!=null)
        {
            return true;
        }
        return false;
    }

    @Override
    public List<Comment> selectAllTopComment(int blog_id) {
        return commentRepository.SelectAllTopComment(blog_id);
    }

    @Override
    public int postTopComment(String nickname, String content, String avatar, int blog_id) {
        Date date = new Date();
//        System.out.printf();
        SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowDate= sf.format(date);
        System.out.println(nowDate);
        String title;
        if(judgeTitle(nickname))
        {
            title="作者";
        }
        else
            title="观众";
        if (commentRepository.postTopComment(nickname,content,avatar,nowDate,blog_id,title)==1)
        {
            return 1;
        }
        else
            return 0;
    }
}
