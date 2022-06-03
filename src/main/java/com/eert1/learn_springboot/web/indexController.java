package com.eert1.learn_springboot.web;

import com.eert1.learn_springboot.Service.UserService;
import com.eert1.learn_springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/")
public class indexController {
    @GetMapping()
    public String index()
    {
        return "test";
    }
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public void login(@RequestBody Map<String,Object> map, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
       String username = (String) map.get("username");
       String password = (String) map.get("password");
       User user;
       user=userService.SelectNaAndPa(username,password);
        System.out.println(user);
        if(userService.SelectNaAndPa(username,password)==null)
        {
            response.getWriter().write("false");
        }
        else
        {
            System.out.println();
            session.setAttribute("user",username);
            response.getWriter().write("ture");
        }
    }
}
