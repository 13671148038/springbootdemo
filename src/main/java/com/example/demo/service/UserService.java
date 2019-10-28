package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by MyPC on 2018/7/16.
 */
public interface UserService {
    Object getPageDate(Map<String,String> map);

    String getUserName(String userName);

    void update();
}
