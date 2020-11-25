package com.example.demo.FactoryBean;

import com.example.demo.pojo.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author zhushaopeng
 * @Date 2020/8/10
 **/
@Component
public class UserFactoryBean implements FactoryBean<User> {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
    }


    @Override
    public User getObject() {
        System.out.println("getObject");
        final User user = new User();
        user.setName("小明");
        user.setUserName("xiaoming");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
