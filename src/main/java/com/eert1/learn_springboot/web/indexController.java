package com.eert1.learn_springboot.web;

import com.eert1.learn_springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class indexController {
//    @GetMapping()
//    public String index()
//    {
//        return "index";
//    }
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(userService.SelectNaAndPa(username,password)==null)
        {
            response.getWriter().write("false");
        }
        else
        {
            session.setAttribute("user",username);
            response.getWriter().write("ture");
        }
    }
}
