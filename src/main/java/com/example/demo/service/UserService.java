package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.List;

/**
 * Created by MyPC on 2018/7/16.
 */
public interface UserService {
    List<User> getPageDate();

    String getUserName();
}
