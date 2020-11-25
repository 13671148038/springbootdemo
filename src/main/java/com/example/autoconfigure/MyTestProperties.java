package com.example.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author zhushaopeng
 * @Date 2020/10/20
 **/
@ConfigurationProperties(prefix = "zhu")
public class MyTestProperties {

    private String name;
    private String age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
