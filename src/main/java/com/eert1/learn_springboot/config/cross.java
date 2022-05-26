package com.eert1.learn_springboot.config;

import com.eert1.learn_springboot.config.Interceptor.LoginInterceptor;
import org.aopalliance.intercept.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.xml.ws.spi.http.HttpHandler;

@Configuration
public class cross implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer crosConfigure(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://127.0.0.1:8080").allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(2000L);
            }
        };
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user")
                .excludePathPatterns("/user/login");
    }
}
