package com.eert1.learn_springboot.pojo;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import jdk.jfr.DataAmount;
import org.apache.tomcat.util.buf.StringUtils;

import javax.xml.soap.Text;
import java.util.Date;
import java.util.List;

//@DataAmount
public class Blog {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content=" + content +
                ", poster='" + poster + '\'' +
                ", likes=" + likes +
                ", postTime=" + postTime +
                ", image='" + image + '\'' +
                ", posterId=" + posterId +
                '}';
    }

    @JSONField(ordinal=1)
    public int id;
    public String title;
    public String content;
    public String poster;
    public int likes;
    public String postTime;
    public String image;
    public int posterId;
    public List<String> imageList;


}
