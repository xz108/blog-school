package com.eert1.learn_springboot.web;

import com.eert1.learn_springboot.Service.GoodService;
import com.eert1.learn_springboot.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/Good")
public class GoodController {
    @Autowired
    GoodService goodService;

    @PostMapping("/PostGood")
    public boolean postGood(@RequestBody Map<String ,Object> map, HttpSession session)
    {   String seller=(String) session.getAttribute("username");
        String image=(String)map.get("image");
        String name =(String)map.get("name");
        String description=(String)map.get("des");
        String state =(String)map.get("state");

        if(goodService.addGoods(name,image,seller,description)==1)
            return true;
        else return false;
    }
    @GetMapping("/GetGoods")
    public List<Good> GetGood()
    {
        return goodService.searchAllGoods();
    }
    @PostMapping("/searchGood")
    public List<Good> searchGood(@RequestBody Map<String,Object> map)
    {
        return goodService.SearchGood((String) map.get("key"));
    }

    @PostMapping("/GetGoodByname")
    public List<Good> GetGoodByname(@RequestBody Map<String,Object> map)
    {
        return goodService.GetAllGoodByName((String) map.get("username"));
    }

    @PostMapping("/closeSell")
    public Boolean CloseGood(@RequestBody Map<String,Object>map)
    {
        String id1 =(String) map.get("gid");
        int id =Integer.parseInt(id1);
        System.out.println(id);
        if(1==goodService.closeSell(id))
        {
            return true;
        }
        else return false;
    }
}
