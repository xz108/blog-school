package com.eert1.learn_springboot.Service;

import com.eert1.learn_springboot.pojo.Good;

import java.util.Date;
import java.util.List;

public interface GoodService {
    public int addGoods(String name, String image, String seller, String description);

    public List<Good> searchAllGoods();
    public int closeSell(int id);

    public List<Good> SearchGood(String key);

    public List<Good> GetAllGoodByName(String name);
}
