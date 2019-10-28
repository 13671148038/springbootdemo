package com.example.demo.aspect.controller;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ControllerLog {
    /**
     * 日志描述信息
     */
    String description() default "";
}
