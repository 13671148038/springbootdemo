package com.example.demo.mapper;

import com.example.demo.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getPageDate(Map<String, Object> condition);

    void insert(User user);

    User getUserByUserName(String username);
}
