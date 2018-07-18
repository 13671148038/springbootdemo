package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.User;

@Mapper
public interface UserDao {
	List<User> getPageDate(Map<String, Object> condition);
	void insert(User user);

    User getUserByUserName(String username);
}
