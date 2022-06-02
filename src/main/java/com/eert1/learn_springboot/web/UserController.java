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

@Controller
@RequestMapping("/User")
//@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public void post(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String username = request.getParameter("username");
        String password =request.getParameter("password");
        System.out.println(username);
        if(userService.register(username,password))
        {
            response.getWriter().write("ture");
        }
//        response.getWriter().write();

        else {
            response.getWriter().write("false");
        }
    }
}