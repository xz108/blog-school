package com.eert1.learn_springboot.Service;

import com.eert1.learn_springboot.pojo.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> selectAllComment(int blog_id);
    public int postComment(String nickname,String content,String avatar,int blog_id);
    public Boolean judgeTitle(int id,String postername);

    public List<Comment> selectAllTopComment(int blog_id);
    public int postTopComment(String nickname,String content,String avatar,int blog_id);


}
