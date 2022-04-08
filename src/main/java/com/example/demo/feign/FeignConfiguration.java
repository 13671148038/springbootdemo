package com.example.demo.feign;

import com.alibaba.fastjson.JSONObject;
import feign.MethodMetadata;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

@Slf4j
public class FeignConfiguration {

    @Bean
    public RequestInterceptor oauthInterceptor() {
        return (RequestTemplate template) -> {
            String path = template.path();
            System.out.println(path);
        };
    }

}
