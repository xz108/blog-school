package com.eert1.learn_springboot.Service.impl;

import com.eert1.learn_springboot.Service.UserService;
import com.eert1.learn_springboot.dao.UserRepository;
import com.eert1.learn_springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserRepository userRepository;
    User user;
    @Override
    public User SelectUser(String username) {
       user= userRepository.selectIdByName(username);
       return user;
    }
    @Override
    public void InsertUser(String username, String password) {
        userRepository.insertUser(username,password);
    }

    @Override
    public User SelectNaAndPa(String username, String password) {
       return userRepository.selectByUserAndPassword(username,password);
    }

    @Override
    public Boolean register(String username, String password) {
        if (userRepository.selectByUser(username)==null)
        {
            //可以注册
            userRepository.insertUser(username,password);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int UpdateUser(String avatar, String newU, String OldU) {
        if (userRepository.UpdateUser(avatar,newU,OldU)!=0) {
            userRepository.UpdateUserBlog(avatar,newU,OldU);
            userRepository.UpdateUserTopComment(avatar,newU,OldU);
            userRepository.UpdateUserGood(avatar,newU,OldU);
            userRepository.UpdateUserTeam(avatar,newU,OldU);
            userRepository.UpdateUserComment(avatar,newU,OldU);
            userRepository.UpdateUserTeamM(avatar,newU,OldU);
            userRepository.UpdateUserBlogTop(avatar,newU,OldU);
            return 1;
        }

        else return 0;

    }



}
