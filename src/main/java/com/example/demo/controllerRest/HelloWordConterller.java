package com.example.demo.controllerRest;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MyPC on 2018/7/13.
 */
@RestController
public class HelloWordConterller {

    @Autowired
    private UserService userService;

    @RequestMapping("helloWord")
    public String HelloWord(){
        return "HelloWord";
    }

    @RequestMapping("getUser")
    public Object getuUser(){
        List<User> list = userService.getPageDate();
        return list;
    }

    @RequestMapping("ajaxTest")
    public String ajaxTest(){
        String userNmae = userService.getUserName();
        return userNmae;
    }
}
