package com.eert1.learn_springboot.Service;

import com.eert1.learn_springboot.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserService {
    public User SelectUser(String username);
}
