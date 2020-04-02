package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan("com.example.mapper")
@EnableScheduling
@SpringBootApplication
public class SpringbootDemoApplication {


    /*private static StringRedisTemplate stringRedisTemplate;

    @Autowired
    public SpringbootDemoApplication(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
        stringRedisTemplate.opsForValue().set("a","test");
        System.out.println("--------------------------------"+stringRedisTemplate.opsForValue().get("a"));;
    }*/

    public static void main(String[] args){
        SpringApplication.run(SpringbootDemoApplication.class,args);
    }


}
