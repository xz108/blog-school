package com.eert1.learn_springboot.pojo;

import javax.xml.crypto.Data;
import javax.xml.soap.Text;
import java.util.Date;
import java.util.List;

public class Good {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String  datetime) {
        this.datetime = datetime;
    }

    int id;
    String name;
   public String image;
    String seller;
    String description;
    String state;
    String datetime;
    String avatar;
    public List imagelist;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
