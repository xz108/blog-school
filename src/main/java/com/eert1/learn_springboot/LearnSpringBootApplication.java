package com.eert1.learn_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//@MapperScan("com.eert1.learn_springboot.dao")
@MapperScan("com.eert1.learn_springboot.dao")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class LearnSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }

}
