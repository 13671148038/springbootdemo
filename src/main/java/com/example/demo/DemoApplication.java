package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.example.demo.mapper")
@SpringBootApplication
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
