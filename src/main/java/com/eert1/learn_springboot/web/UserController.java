package com.eert1.learn_springboot.web;

import com.eert1.learn_springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("http://127.0.0.1:8080")
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/register")
    public String post(@RequestParam("username")String username, @RequestParam("password") String password, Model model)
    {
        model.addAttribute("mode1","modelName");
        userService.InsertUser(username,password);
        return "login";
    }
}