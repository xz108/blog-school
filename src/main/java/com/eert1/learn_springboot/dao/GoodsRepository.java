package com.eert1.learn_springboot.dao;

import com.eert1.learn_springboot.pojo.Good;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Mapper
@Repository("GoodsRepository")
public interface GoodsRepository {
    @Insert("insert into goods value (null,#{name},#{image},#{seller},#{description},'s0',#{datetime})")
    int insertOneGood(@Param("name")String name,
                      @Param("image")String image,
                      @Param("seller")String seller,
                      @Param("description")String description,
                      @Param("datetime") String data);
    @Select("select * from goods")
    List<Good> SelectAllGoods();

    @Update("UPDATE goods set state='s2'where id =#{goodId}")
    int closeSell(int goodId);

    @Select("select * from goods where name like concat('%',#{key},'%')")
    List<Good> SearchGood(String key);

    @Select("select * from goods where seller =#{name})")
    List<Good> GetGoodByname(String name);
}
