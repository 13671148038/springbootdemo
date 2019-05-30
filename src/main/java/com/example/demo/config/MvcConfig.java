package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by MyPC on 2018/7/17.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 登录拦截器
     *
     * @param registry
     */
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());
    }*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/task/toTaskManage").setViewName("task/task_manager");
        registry.addViewController("/user/toUserManage").setViewName("user/user_manager");
    }


}
