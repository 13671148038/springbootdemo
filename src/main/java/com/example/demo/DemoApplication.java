package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.example.demo.mapper")
@SpringBootApplication
@EnableFeignClients
public class DemoApplication {

//public class DemoApplication extends SpringBootServletInitializer {

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }*/
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
