package com.eert1.learn_springboot.web;

import com.eert1.learn_springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/User")
//@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public void post(@RequestBody Map<String,Object> map, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String username = (String) map.get("username");
        String password =(String) map.get("password");
        if(userService.register(username,password))
        {
            response.getWriter().write("ture");
        }
        else {
            response.getWriter().write("false");
        }
    }
}