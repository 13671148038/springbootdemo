package com.example.demo.aspect.service;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ServiceLog {
    /**
     * 日志描述信息
     */
    String description() default "";
}
