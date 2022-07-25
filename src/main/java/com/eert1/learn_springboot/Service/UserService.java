package com.eert1.learn_springboot.Service;

import com.eert1.learn_springboot.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserService {
    public User SelectUser(String username);

    public void InsertUser(String username,String password);

    public User SelectNaAndPa(String username,String password);

    public Boolean register(String username,String password);

    public int UpdateUser(String avatar,String newU,String OldU);
}
