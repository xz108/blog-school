package com.eert1.learn_springboot.Service.impl;

import com.eert1.learn_springboot.Service.GoodService;
import com.eert1.learn_springboot.dao.GoodsRepository;
import com.eert1.learn_springboot.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GoodServiceimpl implements GoodService {
    @Autowired
    GoodsRepository goodsRepository;
    @Override
    public int addGoods(String name, String image, String seller, String description) {
        Date date =new Date();
        SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowDate =sf.format(date);
       int createId = goodsRepository.insertOneGood(name,image,seller,description,nowDate);
       System.out.println(createId);
       if(createId==0)
       {
            return 0;
       }
       else return 1;
    }

    @Override
    public List<Good> searchAllGoods() {
        return goodsRepository.SelectAllGoods();
    }

    @Override
    public int closeSell(int id) {
        int closeNum;
       closeNum= goodsRepository.closeSell(id);
       if (closeNum==1)
           return 1;
       else
           return 0;
    }
}
