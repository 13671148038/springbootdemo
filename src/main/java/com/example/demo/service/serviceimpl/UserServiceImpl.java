package com.example.demo.service.serviceimpl;

import com.example.demo.aspect.controller.ControllerLog;
import com.example.demo.aspect.service.ServiceLog;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by MyPC on 2018/7/16.
 */
@Transactional
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Autowired
    private UserService userService;

    //RedisTemplate 不用手动配置,只要导入依赖就会有,  默认是本地的redis,
    @Resource(name = "redisTemplate")
    private RedisTemplate redis;
   @ServiceLog
    public Object getPageDate(Map<String,String> map) {
        //是jdk8的话可以使用lambda表达式
        PageInfo<User> objectPageInfo = PageHelper.startPage(1, 4).doSelectPageInfo(() -> userDao.getPageDate(null));
       userService.getUserName("userName");
//       redis.opsForSet().intersect()
        return objectPageInfo;
    }

    @ServiceLog
    public String getUserName(String userName) {
        return "dddddcdc";
    }

    public void update() {
        userDao.update();
    }
}
