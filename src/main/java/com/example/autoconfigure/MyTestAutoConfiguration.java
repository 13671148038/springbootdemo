package com.example.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhushaopeng
 * @Date 2020/10/20
 **/
@Configuration
@EnableConfigurationProperties(MyTestProperties.class)
public class MyTestAutoConfiguration {

    public MyTestAutoConfiguration() {
        System.out.println("MyTestAutoConfiguration init =========================================");
    }
}
