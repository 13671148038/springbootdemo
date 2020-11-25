package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.UserService;
import com.example.demo.util.UrlConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        }catch (Exception e){
            log.error("dd",e);
            log.info("ddddddd",e);
        }
    }

    @Test
    public void sdcc(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("https://tuan.stage.ybm100.com/customerimages/750_750.png",String.class);
    }

}
