package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.UserService;
import com.example.demo.util.UrlConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private UrlConfig urlConfig;

    @Test
    public void contextLoads() {
        Object pageDate = userService.getPageDate();
        System.out.println(JSONObject.toJSON(pageDate));
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

}
