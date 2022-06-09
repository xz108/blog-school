package com.eert1.learn_springboot.web;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
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
    {   String seller=(String) map.get("username");
        List image=(List) map.get("image");
        String name =(String)map.get("name");
        String description=(String)map.get("description");
        String state =(String)map.get("state");
        String avatar =(String)map.get("avatar");
        String Json;
        System.out.println(image);
        Json= JSON.toJSONString(image);
        if(goodService.addGoods(name,Json,seller,description,avatar)==1)
            return true;
        else return false;
    }
    @PostMapping("/GetGoods")
    public List<Good> GetGood()
    {
        List<Good>goods=goodService.searchAllGoods();
        for (Good g:
             goods) {
            g.imagelist= JSONUtil.toList(JSONUtil.parseArray(g.image), String.class);
        }
        return goods;
    }
    @PostMapping("/searchGood")
    public List<Good> searchGood(@RequestBody Map<String,Object> map)
    {
        List<Good>goods= goodService.SearchGood((String) map.get("key"));
        for (Good g:
             goods) {g.imagelist=JSONUtil.toList(JSONUtil.parseArray(g.image),String.class);

        }
        return goods;
    }

    @PostMapping("/GetGoodByname")
    public List<Good> GetGoodByname(@RequestBody Map<String,Object> map)
    {
        List<Good>goods= goodService.GetAllGoodByName((String) map.get("username"));
        for (Good good:
             goods) {
            good.imagelist=JSONUtil.toList(JSONUtil.parseArray(good.image),String.class);

        }return goods;
    }

    @PostMapping("/closeSell")
    public Boolean CloseGood(@RequestBody Map<String,Object>map)
    {
        Integer id =(Integer) map.get("id");
        System.out.println(id);
        if(1==goodService.closeSell(id))
        {
            return true;
        }
        else return false;
    }
}
