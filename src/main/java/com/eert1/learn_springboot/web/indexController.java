package com.eert1.learn_springboot.web;

import com.eert1.learn_springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class indexController {
    @GetMapping()
    public String index()
    {
        return "index";
    }
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public String login(@RequestParam String username, HttpSession session)
    {
        if(userService.SelectUser(username)==null)
        {
            return "error/404";
        }
        else
        {
            session.setAttribute("user",username);
            return "error/underBuilt";
        }
    }
}
