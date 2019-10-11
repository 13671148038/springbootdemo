package com.example.demo.service.serviceimpl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MyPC on 2018/7/16.
 */
@Transactional
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    //RedisTemplate 不用手动配置,只要导入依赖就会有,  默认是本地的redis,
   /* @Resource(name = "redisTemplate")
    private RedisTemplate redis;*/
    public Object getPageDate() {
        //是jdk8的话可以使用lambda表达式
        PageInfo<User> objectPageInfo = PageHelper.startPage(1, 4).doSelectPageInfo(() -> userDao.getPageDate(null));
        return objectPageInfo;
    }

    public String getUserName(String userName) {
        log.info("UserServiceImpl.getUserName(req).userName:{}", userName);
        int a = 9 / 0;
        return "";
    }

    public void update() {
        userDao.update();
    }
}
