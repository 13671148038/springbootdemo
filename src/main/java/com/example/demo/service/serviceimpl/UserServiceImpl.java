package com.example.demo.service.serviceimpl;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MyPC on 2018/7/16.
 */
@EnableCaching
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    //RedisTemplate 不用手动配置,只要导入依赖就会有,  默认是本地的redis,
    @Resource(name = "redisTemplate")
    private RedisTemplate redis;

    @Override
    public List<User> getPageDate() {
        PageHelper.startPage(0,3);
        List<User> pageDate = userDao.getPageDate(null);
        return pageDate;
    }

    @Override
    public String getUserName() {
        User user = new User();
        user.setName("zhah");
        user.setUserName("lisijdc刹车");
        redis.opsForValue().set("userName","zhangsan");
        redis.opsForValue().set("user",user);
        String userName = (String)redis.opsForValue().get("userName");
        User user1 = (User)redis.opsForValue().get("user");
        return userName+user1;
    }
}
