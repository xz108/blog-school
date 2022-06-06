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
    @Insert("insert into goods value (null,#{name},#{image},#{seller},#{description},'s0',#{datetime},#{avatar})")
    int insertOneGood(@Param("name")String name,
                      @Param("image")String image,
                      @Param("seller")String seller,
                      @Param("description")String description,
                      @Param("datetime") String data,
                      @Param("avatar")String avatar);
    @Select("select * from goods")
    List<Good> SelectAllGoods();

    @Update("update goods  set state=case\n" +
            "when state ='s2' then 's1'\n" +
            "    else 's2'\n" +
            "end\n" +
            "where  id=#{goodId}")
    int closeSell(int goodId);

    @Select("select * from goods where name like concat('%',#{key},'%')")
    List<Good> SearchGood(String key);

    @Select("select * from goods where seller =#{name})")
    List<Good> GetGoodByname(String name);
}
