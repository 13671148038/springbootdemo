package com.example.demo.controller;

import com.example.demo.aspect.controller.ControllerLog;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cache")
public class CacheController {

    /**
     * 添加缓存，如果引入redis 依赖那么会自动使用redis作为缓存对象
     *
     * @param i
     * @return
     */
    @RequestMapping("cacheTest")
    @Cacheable("id")
    @ControllerLog(description = "sdcsdc少食多餐")
    public int cacheTest(int i) {
        System.out.println("方法被执行了!!!!!!!");
        return i + 9;
    }
}
