package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.UserService;
import com.example.demo.util.UrlConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private UrlConfig urlConfig;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getUserNameTest() {
        userService.getUserName("ddd");
    }

    @Test
    public void update() {
        List<String> servers = urlConfig.getServers();
        System.out.println(JSONObject.toJSON(servers).toString());
        String lisi = urlConfig.getLisi();
        System.out.println(lisi);
        String zsp = urlConfig.getZsp();
        System.out.println(zsp);
    }

    @Test
    public void bbbb() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap(c -> c, Function.identity()));
            collect.forEach((k, v) -> System.out.println(k + ":" + v));
        } catch (Exception e) {
            log.error("dd", e);
            log.info("ddddddd", e);
        }
    }

    @Test
    public void sdcc() {
        RestTemplate restTemplate = new RestTemplate();

        MediaType type = MediaType.parseMediaType("multipart/form-data");
        // 设置请求的格式类型
        FileSystemResource fileSystemResource = new FileSystemResource("C:/Users/admin/Pictures/214DC3DD-2E3B-40A0-A80A-4DD8D49A25D6.png");
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("", fileSystemResource);

        long time = new Date().getTime();
        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.add("Authorization", "");
        requestHeaders.add("Content-Encoding", "utf-8");
        requestHeaders.setContentType(type);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(form, requestHeaders);
        Map<String, String> param = new HashMap<>();
        String url = "";
        String s = restTemplate.postForObject(url, requestEntity, String.class, param);
        System.out.println(s);

    }

}
