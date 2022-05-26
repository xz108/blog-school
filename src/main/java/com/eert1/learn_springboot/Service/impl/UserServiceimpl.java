package com.eert1.learn_springboot.Service.impl;

import com.eert1.learn_springboot.Service.UserService;
import com.eert1.learn_springboot.dao.UserRepository;
import com.eert1.learn_springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceimpl implements UserService {
    @Autowired
    UserRepository userRepository;
    User user;
    @Override
    public User SelectUser(String username) {
       user= userRepository.selectByUser(username);
       return user;
    }

    @Override
    public void InsertUser(String username, String password) {
        userRepository.insertUser(username,password);
    }
}
