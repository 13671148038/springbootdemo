package com.example.demo;

import com.example.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author zhushaopeng
 * @Date 2020/8/10
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserFactoryBeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private User user3;

    @Test
    public void aa() throws Exception {
//        User user = (User) applicationContext.getBean("userFactoryBean");
//        User user1 = (User) applicationContext.getBean("userFactoryBean");
//        System.out.println(user == user1);
//        System.out.println(user);
//        System.out.println(user1);
        System.out.println(user3);

    }

}
