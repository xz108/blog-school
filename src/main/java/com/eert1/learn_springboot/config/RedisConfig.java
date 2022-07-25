package com.eert1.learn_springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,Object>redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object>redisTemplate =new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //指定k,v值序列化方式
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =new Jackson2JsonRedisSerializer(Object.class);
//        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return  redisTemplate;

    }
}
