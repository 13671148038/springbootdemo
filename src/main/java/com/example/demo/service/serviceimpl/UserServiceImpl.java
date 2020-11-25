package com.example.demo.service.serviceimpl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    @Resource(name = "redisTemplate")
    private RedisTemplate redis;

    public Object getPageDate(Map<String, String> map) {
        //是jdk8的话可以使用lambda表达式
        PageInfo<User> objectPageInfo = PageHelper.startPage(1, 4).doSelectPageInfo(() -> userDao.getPageDate(null));
//       redis.opsForSet().intersect()
        return objectPageInfo;
    }

    public String getUserName(String userName) {
        ValueOperations valueOperations = redis.opsForValue();
        Boolean lock = valueOperations.setIfAbsent("zshaaa", userName, 10, TimeUnit.SECONDS);
        if(lock){

        }
        log.info("aBoolean:{}",lock);
        String zshaaa = (String) valueOperations.get("zshaaa");
        return zshaaa + "" + lock;
    }

    public void update1() {
        userDao.update1();
        int a = 8;
        System.out.println(a);
    }

    @Override
    public void update2() {
        userDao.update("cccc");
        int a = 8;
        System.out.println(a);
    }
}
