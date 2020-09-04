package com.example.demo.service;

import java.util.Map;

/**
 * Created by MyPC on 2018/7/16.
 */
public interface UserService {
    Object getPageDate(Map<String, String> map);

    String getUserName(String userName);

    void update1();

    void update2();
}
